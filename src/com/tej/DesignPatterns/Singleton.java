package com.tej.DesignPatterns;

/*
    This is a singleton class. i.e. There only exists a single instance of this class at any given point of time.
    No matter how many times it is initialized.

    The only time there might be multiple instances of this singleton class if the program we write has thread
    implementation in it.

*/

/*
    When to use singleton pattern
    - For resources that are expensive to create (like database connection objects)
    - It’s good practice to keep all loggers as Singletons which increases performance
    - Classes which provide access to configuration settings for the application
    - Classes that contain resources that are accessed in shared mode
 */

public class Singleton {
    private static Singleton instance;
    private static int value;
    private Singleton(){
        // empty constructor
    }

    public static Singleton getInstance(){
        if(instance == null){
           instance = new Singleton();
           value = 1;
        }
        return instance;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int v){
        value = v;
    }
}
