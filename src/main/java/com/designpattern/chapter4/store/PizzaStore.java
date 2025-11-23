package com.designpattern.chapter4.store;

import com.designpattern.chapter4.pizza.Pizza;

public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type); // createPizza 函數是子類別的實作

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza(String type); // 子類別需要實作 createPizza 函數
}

