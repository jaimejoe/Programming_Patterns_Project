package org.example.controller;

import org.example.model.FoodItem;
import org.example.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderFactory {
    public static Order createOrder(int userId, List<FoodItem> foodItems) {
        List<FoodItem> items = new ArrayList<>();
        double totalPrice = 0;

        for (FoodItem foodItem : foodItems) {
            FoodItem orderItem = new FoodItem(foodItem.getName(), foodItem.getPrice());
            items.add(orderItem);
            totalPrice += foodItem.getPrice();
        }
        Order order = new Order();
        order.setCustomerId(userId);
        order.setProcessStatus("Pending");
        order.setItems(items);
        order.setPrice(totalPrice);
        return order;
    }
}
