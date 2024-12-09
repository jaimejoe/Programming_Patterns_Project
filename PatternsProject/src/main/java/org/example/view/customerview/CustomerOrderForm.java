package org.example.view.customerview;

import org.example.controller.FoodItemFactory;
import org.example.model.FoodItem;
import org.example.model.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerOrderForm extends JFrame {
    private JPanel mainPanel;
    private JButton pizzaButton;
    private JButton burgerButton;
    private JButton saladButton;
    private JButton hotDogButton;
    private JButton submitButton;

    // Create an order instance
    private Order order;

    public CustomerOrderForm() {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        order = new Order();
        order.setProcessStatus("Pending"); // Set initial status

        // Add action listeners for buttons
        pizzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleFoodItemSelection(FoodItemFactory.createPizza());
            }
        });

        burgerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleFoodItemSelection(FoodItemFactory.createBurger());
            }
        });

        saladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleFoodItemSelection(FoodItemFactory.createSalad());
            }
        });

        hotDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleFoodItemSelection(FoodItemFactory.createHotDog());
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle payment process here
                JOptionPane.showMessageDialog(mainPanel, "Proceeding to payment. Total: $" + order.getPrice());
                order.setItems(new ArrayList<>()); // Clear items after payment
                order.setPrice(0); // Reset price
            }
        });
    }

    private void handleFoodItemSelection(FoodItem item) {
        MealSelectionDialog dialog = new MealSelectionDialog();
        dialog.setVisible(true);

        // Assuming MealSelectionDialog has a method to get the user's choice
        boolean isMealSelected = dialog.isMealSelected(); // You need to implement this method in MealSelectionDialog

        if (isMealSelected) {
            double mealPrice = item.getPrice() * 1.5; // Increase price by 1.5 times
            item.setPrice(mealPrice); // Update the price for the meal
            JOptionPane.showMessageDialog(mainPanel, "Meal selected: " + item.getName() + " - Price: $" + mealPrice);
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Single item selected: " + item.getName() + " - Price: $" + item.getPrice());
        }

        // Add the item to the order
        order.getItems().add(item);
        order.setPrice(order.getPrice() + item.getPrice());
        JOptionPane.showMessageDialog(mainPanel, item.getName() + " added to order. Total: $" + order.getPrice());
    }
}