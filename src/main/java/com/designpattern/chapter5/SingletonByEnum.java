package com.designpattern.chapter5;

public enum SingletonByEnum {
  INSTANCE;

  SingletonByEnum() {
    new OneSecondBox();
  }

  public void someMethod() {
    // Method implementation
  }
}