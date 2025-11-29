package com.designpattern.chapter5;

public class SingletonPrivateLoader {
    private static class Loader {
        private static final SingletonPrivateLoader INSTANCE = new SingletonPrivateLoader();
    }

    private SingletonPrivateLoader() {
       new OneSecondBox();
    }

    public static SingletonPrivateLoader getInstance() {
        return Loader.INSTANCE;
    }

    public void someMethod() {
        // Method implementation
    }
}
