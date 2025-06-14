package com.designpattern.chapter1.simulateDuck.duck;

import com.designpattern.chapter1.simulateDuck.fly.FlyWithWings;
import com.designpattern.chapter1.simulateDuck.quack.Quack;

public class MallardDuck extends Duck {

  public MallardDuck() {
    quackBehavior = new Quack();
    flyBehavior = new FlyWithWings();
  }

  @Override
  public void display() {
    System.out.println("I'm a real Mallard duck");
  }

}
