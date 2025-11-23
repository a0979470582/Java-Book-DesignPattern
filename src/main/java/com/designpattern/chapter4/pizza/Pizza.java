package com.designpattern.chapter4.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String name;
    String dough; // 麵團
    String sauce; // 醬料
    List<String> toppings = new ArrayList<String>(); // 配料

    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("dough: " + dough);
        System.out.println("sauce: " + sauce);
        System.out.println("toppings: " + String.join(", ", toppings));
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
