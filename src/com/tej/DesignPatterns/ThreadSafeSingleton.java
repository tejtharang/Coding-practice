package com.tej.DesignPatterns;

/*

    This version of singleton has only a single instance even with multiple threads.

    Notice that we make the class attributes private static final and directly return the threads in the next
 */

public class ThreadSafeSingleton {
    private static final ThreadSafeSingleton threadSafeSingleton = new ThreadSafeSingleton();
    private static int value;
    private ThreadSafeSingleton(){

    }
    public int getValue(){
        return value;
    }

    public void setValue(int v){
        value = v;
    }

    public static ThreadSafeSingleton getThreadSafeSingleton(){
        value = 1;
        return threadSafeSingleton;
    }
}
