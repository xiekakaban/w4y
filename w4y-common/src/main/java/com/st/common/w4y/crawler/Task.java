package com.st.common.w4y.crawler;

/**
 * Created by ruantianbo on 2017/11/13.
 */
public interface Task<T> {

    void execute();
    T getResult();
}
