package com.designpattern.chapter5;

public class SingletonNotThreadSafe {
    private static SingletonNotThreadSafe instance;

    private SingletonNotThreadSafe() {
        new OneSecondBox();
    }

    public static SingletonNotThreadSafe getInstance() {
        if (instance == null) {
            instance = new SingletonNotThreadSafe();
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
