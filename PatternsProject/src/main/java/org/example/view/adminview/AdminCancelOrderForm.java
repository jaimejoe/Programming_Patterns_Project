package org.example.view.adminview;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminCancelOrderForm extends JFrame {
    private JList orderList;
    private JTextField idTextField;
    private JButton cancelButton;
    private JLabel idLabel;
    private JPanel mainPanel;



    public AdminCancelOrderForm() {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        List<Order> orders = DatabaseUtil.queryAllOrders();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Order order : orders) {
            listModel.addElement("Order ID: " + order.getOrderId() + ", Customer ID: " + order.getCustomerId() + ", Total: $" + order.getPrice());
        }
        orderList.setModel(listModel);

    }
    public JList getOrderList() {
        return orderList;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
