package org.example.view.adminview;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Order;

import javax.swing.*;
import java.util.List;

public class AdminProcessOrderForm extends JFrame {

    private JPanel mainPanel;
    private JList orderList;
    private JTextField idTextField;
    private JButton processButton;
    private JLabel idLabel;
    private JButton backButton;

    public AdminProcessOrderForm() {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        List<Order> orders = DatabaseUtil.queryAllOrders();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Order order : orders) {
            listModel.addElement("Order ID: " + order.getOrderId() + ", Customer ID: " + order.getCustomerId() +
                    ", Total: $" + order.getPrice() + ", Status: " + order.getProcessStatus());
        }
        orderList.setModel(listModel);

    }

    public JButton getBackButton() {
        return backButton;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JList getOrderList() {
        return orderList;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JButton getProcessButton() {
        return processButton;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }
}