package com.designpattern.chapter4.pizza;

import com.designpattern.chapter4.ingredient.IngredientFactory;

public class CheesePizza extends Pizza {
    IngredientFactory ingredientFactory;

    public CheesePizza(IngredientFactory ingredientFactory, String name) {
        this.ingredientFactory = ingredientFactory;
        this.name = name;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        toppings.add(ingredientFactory.createToppings());
        System.out.println("dough: " + dough);
        System.out.println("sauce: " + sauce);
        System.out.println("toppings: " + String.join(", ", toppings));
    }
}
