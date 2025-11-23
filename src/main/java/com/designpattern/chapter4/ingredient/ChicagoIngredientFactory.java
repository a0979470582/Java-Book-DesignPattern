package com.designpattern.chapter4.ingredient;

public class ChicagoIngredientFactory implements IngredientFactory {
    @Override
    public String createDough() {
        return "Chicago-Dough";
    }

    @Override
    public String createSauce() {
        return "Chicago-Sauce";
    }

    @Override
    public String createToppings() {
        return "Chicago-Toppings";
    }
}
