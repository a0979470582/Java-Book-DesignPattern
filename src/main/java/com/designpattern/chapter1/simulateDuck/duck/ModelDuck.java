package com.designpattern.chapter1.simulateDuck.duck;

import com.designpattern.chapter1.simulateDuck.fly.FlyNoWay;
import com.designpattern.chapter1.simulateDuck.quack.Quack;

public class ModelDuck extends Duck {

  public ModelDuck() {
    flyBehavior = new FlyNoWay();
    quackBehavior = new Quack();
  }

  @Override
  public void display() {
    System.out.println("I'm a model duck");
  }

}
