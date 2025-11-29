package com.designpattern.chapter5;

public class OneSecondBox {
  public OneSecondBox() {
    try {
      // Simulate some delay
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
