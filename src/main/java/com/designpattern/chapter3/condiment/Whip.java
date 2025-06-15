package com.designpattern.chapter3.condiment;

import com.designpattern.chapter3.beverage.Beverage;

public class Whip extends CondimentDecorator {
  private Beverage beverage;

  public Whip(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Whip";
  }

  @Override
  public double cost() {
    return beverage.cost() + 0.10;
  }

}
