package com.designpattern.chapter1.simulateDuck;

import com.designpattern.chapter1.simulateDuck.duck.Duck;
import com.designpattern.chapter1.simulateDuck.duck.MallardDuck;

public class Main {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performQuack();
        mallardDuck.performFly();
    }
}