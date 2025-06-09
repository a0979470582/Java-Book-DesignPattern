package com.designpattern.chapter1.simulateDuck.quack;

public class MuteQuack implements QuackBehavior {
  @Override
  public void quack() {
    // Do nothing, as this duck does not quack
    System.out.println("<< Silence >>");
  }
}
