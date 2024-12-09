package org.example.controller;

import org.example.model.FoodItem;

public class FoodItemFactory {
    public static FoodItem createPizza() {
        return new FoodItem("Pizza", 4.0);
    }

    public static FoodItem createSalad() {
        return new FoodItem("Salad", 3.0);
    }

    public static FoodItem createHotDog() {
        return new FoodItem("Hot Dog", 2.0);
    }

    public static FoodItem createBurger() {
        return new FoodItem("Burger", 5.0);
    }
}