package com.dogacoder.www.objectpool;

import java.util.concurrent.TimeUnit;

public interface BlockingPool<T> extends Pool<T> {

    T borrowObject();

    T borrowObject(long timeInMillis, TimeUnit timeUnit);

}
