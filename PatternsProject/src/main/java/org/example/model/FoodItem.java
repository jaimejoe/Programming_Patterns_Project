package org.example.model;

public class FoodItem {
    public String name;
    public double price;
    public int count;
    public int id;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.id = count++;
    }

    @Override
    public String toString() {
        return name + '\n' + price + "$, " + "id:" + id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
