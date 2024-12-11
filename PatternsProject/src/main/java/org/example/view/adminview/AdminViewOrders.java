package org.example.view.adminview;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Order;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AdminViewOrders extends JFrame {
    private JList orderList;
    private JPanel panel1;
    private JLabel orderLabel;

    public AdminViewOrders() {
        setContentPane(panel1);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        List<Order> orders = DatabaseUtil.queryAllOrders();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Order order : orders) {
            listModel.addElement("Order ID: " + order.getOrderId() + ", Customer ID: " + order.getCustomerId()
                    + ", Total: $" + order.getPrice() + ", Status: " + order.getProcessStatus());
        }
        orderList.setModel(listModel);
    }

    public JList getOrderList() {
        return orderList;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JLabel getOrderLabel() {
        return orderLabel;
    }
}
