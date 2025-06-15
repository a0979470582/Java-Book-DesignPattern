package com.designpattern.chapter3.condiment;

import com.designpattern.chapter3.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
    public abstract double cost();
}
