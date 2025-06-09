package com.designpattern.chapter1.simulateDuck.quack;

public class Quack implements QuackBehavior {
  @Override
  public void quack() {
    System.out.println("Quack");
  }
}
