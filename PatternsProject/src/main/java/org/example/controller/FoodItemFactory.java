package org.example.controller;

import org.example.model.FoodItem;

public class FoodItemFactory {
    /**
     * creates food item pizza
     * @return a pizza food item
     */
    public static FoodItem createPizza() {
        return new FoodItem("Pizza", 4.0);
    }

    /**
     * creates salad food item
     * @return a salad food item
     */
    public static FoodItem createSalad() {
        return new FoodItem("Salad", 3.0);
    }

    /**
     * creates Hot dog food item
     * @return a hot dog food item
     */
    public static FoodItem createHotDog() {
        return new FoodItem("Hot Dog", 2.0);
    }

    /**
     * creates a burger food item
     * @return a burger item
     */
    public static FoodItem createBurger() {
        return new FoodItem("Burger", 5.0);
    }
}