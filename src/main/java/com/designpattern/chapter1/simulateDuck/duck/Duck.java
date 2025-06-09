package com.designpattern.chapter1.simulateDuck.duck;

import com.designpattern.chapter1.simulateDuck.fly.FlyBehavior;
import com.designpattern.chapter1.simulateDuck.quack.QuackBehavior;

public abstract class Duck {
  FlyBehavior flyBehavior;
  QuackBehavior quackBehavior;

  public Duck() {}

  public abstract void display();
  public void performFly() {
    flyBehavior.fly();
  }
  public void performQuack() {
    quackBehavior.quack();
  }
  public void swim() {
    System.out.println("All ducks float, even decoys!");
  }
}
