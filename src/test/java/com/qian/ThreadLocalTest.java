package com.qian;

import java.util.TreeMap;

/**
 * Created by qld on 2017/8/28.
 */
public class ThreadLocalTest {


        ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
       // ThreadLocal<TreeMap<String,String>> stringLocal = new ThreadLocal<TreeMap<String,String>>();
         TreeMap<String,String> stringLocal=new TreeMap<String,String>();

        public void set(String value) {
//            TreeMap<String,String> tm=new TreeMap<String,String>();
//            tm.put("1",value);
            longLocal.set(Thread.currentThread().getId());
           // stringLocal.set(tm);
            stringLocal.put("1",value);
        }

        public long getLong() {
            return longLocal.get();
        }

        public TreeMap<String,String> getString() {
            return stringLocal;
        }

        public static void main(String[] args) throws InterruptedException {
            final ThreadLocalTest test = new ThreadLocalTest();


            test.set("first");
            System.out.println(test.getLong());
            System.out.println(test.getString());


            Thread thread1 = new Thread(){
                public void run() {
                    test.set("sencend");
                    System.out.println("线程一:"+test.getLong());
                    System.out.println("线程一:"+test.getString());
                };
            };
            thread1.start();
            thread1.join();

            Thread thread2 = new Thread(){
                public void run() {
                    test.set("third");
                    System.out.println("线程二:"+test.getLong());
                    System.out.println("线程二:"+test.getString());
                };
            };
            thread2.start();
            thread2.join();

            System.out.println("第二个:"+test.getLong());
            System.out.println("第二个:"+test.getString());
        }

}
