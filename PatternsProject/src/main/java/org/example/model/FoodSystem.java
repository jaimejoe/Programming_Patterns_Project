package org.example.model;

import javax.swing.text.html.CSS;
import java.util.List;

public class FoodSystem {
    public List<Customer> customers;
    public List<Driver> drivers;
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

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
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
