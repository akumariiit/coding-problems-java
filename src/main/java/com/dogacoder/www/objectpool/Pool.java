package com.dogacoder.www.objectpool;

public interface Pool<T> {

    T borrowObject();

    void returnObject(T t);

    void shutDown();

    interface Validator<T> {
        boolean isValid(T t);

        void invalidate(T t);
    }
}
