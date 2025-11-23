package com.designpattern.chapter4;

import com.designpattern.chapter4.pizza.Pizza;
import com.designpattern.chapter4.store.ChicagoStore;
import com.designpattern.chapter4.store.NYPizzaStore;
import com.designpattern.chapter4.store.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}



