package com.qian.common;

import java.util.Map;

/**
 * Created by qld on 2017/9/6.
 */
public class AppContext {

    //申明这样一个静态变量存储线程的信息
    public static  ThreadLocal<String> sLocal=new ThreadLocal<String>();

    //不同的参数类型变量，搞起来
    public static  ThreadLocal<Map<String,Object>> mapLocal=new ThreadLocal<Map<String,Object>>();




}
