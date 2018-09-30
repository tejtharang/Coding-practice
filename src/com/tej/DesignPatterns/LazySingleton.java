package com.tej.DesignPatterns;

public class LazySingleton {
    private static LazySingleton lazySingleton;

    private LazySingleton(){
        //empty constructor
    }

    private static synchronized LazySingleton getLazySingleton(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
