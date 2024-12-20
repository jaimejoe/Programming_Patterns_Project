package org.example.view.customerview;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Customer;
import org.example.model.Order;

import javax.swing.*;
import java.util.List;

public class CustomerViewForm extends JFrame{
    private JList orderList;
    private JPanel mainPanel;
    private JLabel orderLabel;
    private JButton backButton;

    public CustomerViewForm(Customer customer) {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        List<Order> orders = DatabaseUtil.queryOrdersByCustomerId(customer.getCustomerId());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Order order : orders) {
            order.setCustomer(customer);
            listModel.addElement("Order ID: " + order.getOrderId() + ", Total: $" + order.getPrice());
        }
        orderList.setModel(listModel);
    }

    public JList getOrderList() {
        return orderList;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getOrderLabel() {
        return orderLabel;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
