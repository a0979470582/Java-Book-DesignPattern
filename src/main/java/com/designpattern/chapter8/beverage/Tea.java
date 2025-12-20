package com.designpattern.chapter8.beverage;

public class Tea extends CaffeineBeverage {
  @Override
  protected void brew() {
    System.out.println("Steeping the tea");
  }

  @Override
  protected void addCondiments() {
    System.out.println("Adding lemon");
  }
}
