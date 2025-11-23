package com.designpattern.chapter4.store;

import com.designpattern.chapter4.ingredient.ChicagoIngredientFactory;
import com.designpattern.chapter4.ingredient.IngredientFactory;
import com.designpattern.chapter4.pizza.CheesePizza;
import com.designpattern.chapter4.pizza.Pizza;

public class ChicagoStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        IngredientFactory ingredientFactory = new ChicagoIngredientFactory();

        if (type.equals("cheese")) {
            return new CheesePizza(ingredientFactory, "Chicago Style Cheese Pizza");
        } else {
            throw new IllegalArgumentException("ChicagoStore >>> Unknown pizza type: " + type);
        }
    }
}
