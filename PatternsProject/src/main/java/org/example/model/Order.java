package org.example.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    public int orderId;
    public int count = 0;
    public int customerId;
    public double price;
    public List<FoodItem> items;
    public String processStatus;
    public LocalDateTime dateCreated;

    public Order() {
    }

    public Order(int customerId, double price, List<FoodItem> items, String processStatus, LocalDateTime dateCreated) {
        this.orderId = count++;
        this.customerId = customerId;
        this.price = price;
        this.items = items;
        this.processStatus = processStatus;
        this.dateCreated = dateCreated;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public void setItems(List<FoodItem> items) {
        this.items = items;
    }

    public String isProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
