package com.designpattern.chapter1.simulateDuck.quack;

public class Squeak implements QuackBehavior {
  @Override
  public void quack() {
    System.out.println("Squeak");
  }
}
