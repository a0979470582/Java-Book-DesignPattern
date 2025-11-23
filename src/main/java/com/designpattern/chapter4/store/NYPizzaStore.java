package com.designpattern.chapter4.store;

import com.designpattern.chapter4.ingredient.IngredientFactory;
import com.designpattern.chapter4.ingredient.NYIngredientFactory;
import com.designpattern.chapter4.pizza.CheesePizza;
import com.designpattern.chapter4.pizza.Pizza;

public class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        IngredientFactory ingredientFactory = new NYIngredientFactory();

        if (type.equals("cheese")) {
            return new CheesePizza(ingredientFactory, "New York Style Cheese Pizza");
        } else {
            throw new IllegalArgumentException("NYPizzaStore >>> Unknown pizza type: " + type);
        }
    }
}
