package com.designpattern.chapter1.simulateDuck;

import com.designpattern.chapter1.simulateDuck.duck.Duck;
import com.designpattern.chapter1.simulateDuck.duck.MallardDuck;
import com.designpattern.chapter1.simulateDuck.duck.ModelDuck;
import com.designpattern.chapter1.simulateDuck.fly.FlyRocketPowered;

public class Main {
    public static void main(String[] args) {
        System.out.println("Duck Simulation: MallardDuck");
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performQuack();
        mallardDuck.performFly();

        System.out.println("Duck Simulation: ModelDuck");
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered()); // Change the fly behavior dynamically
        modelDuck.performFly();
    }
}