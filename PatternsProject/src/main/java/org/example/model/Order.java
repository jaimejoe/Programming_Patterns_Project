package org.example.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    public int orderId;
    public int count = 0;
    public Customer customer;
    public int customerId;
    public double price;
    public List<FoodItem> items;
    public String itemsString;
    public String processStatus;

    public Order() {
    }

    public Order(Customer customer, double price, List<FoodItem> items, String processStatus) {
        this.orderId = count++;
        this.customer = customer;
        this.price = price;
        this.items = items;
        this.processStatus = processStatus;
    }

    public Order(int orderId, int customerId , double price, String items, String processStatus) {
        this.orderId = orderId;
        this.price = price;
        this.itemsString = items;
        this.processStatus = processStatus;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getProcessStatus() {
        return processStatus;
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

}
