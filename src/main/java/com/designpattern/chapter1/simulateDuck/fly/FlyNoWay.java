package com.designpattern.chapter1.simulateDuck.fly;

public class FlyNoWay implements FlyBehavior {
  @Override
  public void fly() {
    System.out.println("I can't fly!");
  }
}
