package org.example.model;

import java.util.List;

public class FoodSystem {
    public List<Customer> customers;
    public List<UserDriver> userDrivers;
    public List<Admin> admins;
    public List<Order> orders;
    public List<FoodItem> foodItems;
    public static FoodSystem foodSystem;

    private FoodSystem() {
    }

    public static FoodSystem getInstance() {
        if (foodSystem == null) {
            synchronized (FoodSystem.class) {
                if (foodSystem == null) {
                    foodSystem = new FoodSystem();
                }
            }
        }
        return foodSystem;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<UserDriver> getDrivers() {
        return userDrivers;
    }

    public void setDrivers(List<UserDriver> userDrivers) {
        this.userDrivers = userDrivers;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
