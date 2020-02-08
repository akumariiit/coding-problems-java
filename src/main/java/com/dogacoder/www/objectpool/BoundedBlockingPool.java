package com.dogacoder.www.objectpool;

import java.util.concurrent.*;

public final class BoundedBlockingPool<T> extends AbstractPool<T> implements BlockingPool<T> {

    private final int size;
    private final ObjectFactory<T> objectFactory;
    private final Validator<T> validator;
    private BlockingQueue<T> objects;
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private volatile boolean shutdownCalled;

    public BoundedBlockingPool(int size, ObjectFactory<T> objectFactory, Validator<T> validator) {
        this.size = size;
        this.objectFactory = objectFactory;
        this.validator = validator;
        objects = new LinkedBlockingQueue < T >(size);
        shutdownCalled = false;
        initObjects();
    }

    private void initObjects() {
        for(int i = 0; i < size; i++) {
            objects.add(objectFactory.createObject());
        }
    }

    @Override
    protected void handleInvalidObject(T t) {

    }

    @Override
    protected void returnObjectBackToPool(T t) {
        if (validator.isValid(t)) {
            executorService.submit(new ObjectReturner(objects, t));
        }

    }

    @Override
    protected boolean isValid(T t) {
        return validator.isValid(t);
    }

    @Override
    public T borrowObject(long timeInMillis, TimeUnit timeUnit) {
        if (!shutdownCalled) {
            T t = null;
            try {
                t = objects.poll(timeInMillis, timeUnit);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return t;
        }
        throw new IllegalStateException("Pool is already shut down");
    }

    @Override
    public T borrowObject() {
        if (!shutdownCalled) {
            T t = null;
            try {
                t = objects.take();
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return t;
        }
        throw new IllegalStateException("Pool is already shut down");
    }

    @Override
    public void shutDown() {
        shutdownCalled = true;
        executorService.shutdownNow();
        clearResources();
    }

    private void clearResources() {
        for(T t : objects) {
            validator.invalidate(t);
        }
    }

    private class ObjectReturner<T> implements Callable<Void> {
        private final BlockingQueue<T> blockingQueue;
        private final T object;

        public ObjectReturner(BlockingQueue<T> blockingQueue, T object) {
            this.blockingQueue = blockingQueue;
            this.object = object;
        }

        @Override
        public Void call() {
            while (true) {
                try {
                    blockingQueue.put(object);
                    break;
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            return null;
        }
    }
}
