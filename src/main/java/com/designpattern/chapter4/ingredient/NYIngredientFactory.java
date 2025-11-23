package com.designpattern.chapter4.ingredient;

public class NYIngredientFactory implements IngredientFactory {
    @Override
    public String createDough() {
        return "NY-Dough";
    }

    @Override
    public String createSauce() {
        return "NY-Sauce";
    }

    @Override
    public String createToppings() {
        return "NY-Toppings";
    }
}
