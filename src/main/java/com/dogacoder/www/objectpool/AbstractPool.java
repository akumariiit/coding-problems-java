package com.dogacoder.www.objectpool;

public abstract class AbstractPool<T> implements Pool<T> {

    @Override
    public void returnObject(T t) {
        if (isValid(t)) {
            returnObjectBackToPool(t);
        }
        else {
            handleInvalidObject(t);
        }
    }

    protected abstract void handleInvalidObject(T t);

    protected abstract void returnObjectBackToPool(T t);

    protected abstract boolean isValid(T t);
}
