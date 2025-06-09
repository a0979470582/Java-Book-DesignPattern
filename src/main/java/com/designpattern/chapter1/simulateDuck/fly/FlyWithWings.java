package com.designpattern.chapter1.simulateDuck.fly;

public class FlyWithWings implements FlyBehavior {
  @Override
  public void fly() {
    System.out.println("I'm flying with wings!");
  }
}
