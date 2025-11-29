package com.designpattern.chapter5;

public class SingletonThreadSafe {
    private static volatile SingletonThreadSafe instance;

    private SingletonThreadSafe() {
        new OneSecondBox();
    }

    public static SingletonThreadSafe getInstance() {
        if (instance == null) {
            synchronized (SingletonThreadSafe.class) {
                if (instance == null) {
                    instance = new SingletonThreadSafe();
                }
            }
        }
        return instance;
    }

    public static void clearInstance() {
        instance = null;
    }

    public void someMethod() {
        // Method implementation
    }
}