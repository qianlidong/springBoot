package com.qian.domain;

/**
 * Created by qld on 2017/8/24.
 */
public class MyException extends Exception {

    public  MyException(String message,Exception e){
        super(message, e);
    }

    public MyException(String message){
        super(message);
    }
}
