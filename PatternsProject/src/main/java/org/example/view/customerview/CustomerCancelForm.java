package org.example.view.customerview;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Customer;
import org.example.model.Order;

import javax.swing.*;
import java.util.List;

public class CustomerCancelForm extends JFrame {
    private JList orderList;
    private JTextField idTextField;
    private JButton cancelButton;
    private JLabel idLabel;
    private JPanel mainPanel;
    private JButton backButton;

    public CustomerCancelForm(Customer customer) {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        List<Order> orders = DatabaseUtil.queryOrdersByCustomerId(customer.getCustomerId());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Order order : orders) {
            order.setCustomer(customer);
            listModel.addElement("Order ID: " + order.getOrderId() + ", Total: $" + order.getPrice());
        }
        orderList.setModel(listModel);

    }
    public JButton getBackButton() {
        return backButton;
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
