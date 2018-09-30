package com.tej.DesignPatterns;


public class Main {
    public static void main(String[] args) {

        // ordinary singleton class implementation
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println("singleton1 value " + singleton1.getValue());
        System.out.println("singleton2 value " + singleton2.getValue());

        singleton1.setValue(4);
        System.out.println("After change in singleton1's value");
        System.out.println("singleton1 value " + singleton1.getValue());
        System.out.println("singleton2 value " + singleton2.getValue());

        // Thread safe singleton implementation
        ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getThreadSafeSingleton();
        ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getThreadSafeSingleton();

        System.out.println("singleton1 value " + threadSafeSingleton1.getValue());
        System.out.println("singleton2 value " + threadSafeSingleton2.getValue());

        threadSafeSingleton1.setValue(4);
        System.out.println("After change in thread safe singleton1's value");
        System.out.println("singleton1 value " + threadSafeSingleton1.getValue());
        System.out.println("singleton2 value " + threadSafeSingleton2.getValue());


    }
}
