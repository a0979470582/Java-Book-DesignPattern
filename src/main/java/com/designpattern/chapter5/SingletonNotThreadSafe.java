package com.designpattern.chapter5;

public class SingletonNotThreadSafe {
    private static SingletonNotThreadSafe instance;

    private SingletonNotThreadSafe() {
        new OneSecondBox();
    }

    public static SingletonNotThreadSafe getInstance() {
        if (instance == null) {
            // Simulate some delay to increase the chance of race condition
            delay(1000);
            instance = new SingletonNotThreadSafe();
        }
        return instance;
    }

    private static void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearInstance() {
        instance = null;
    }

    public void someMethod() {
        // Method implementation
    }
}
