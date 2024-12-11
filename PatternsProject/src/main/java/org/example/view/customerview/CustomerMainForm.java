package org.example.view.customerview;

import org.example.model.Customer;

import javax.swing.*;
import java.awt.*;

public class CustomerMainForm extends JFrame {
    private JPanel mainPanel;
    private JLabel customerOptionsLabel;
    private JButton orderButton;
    private JButton cancelOrderButton;
    private JButton viewOrdersButton;
    private JButton backButton;

    public CustomerMainForm(Customer customer) throws HeadlessException {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    public JButton getBackButton() {
        return backButton;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getCustomerOptionsLabel() {
        return customerOptionsLabel;
    }

    public JButton getOrderButton() {
        return orderButton;
    }

    public JButton getCancelOrderButton() {
        return cancelOrderButton;
    }

    public JButton getViewOrdersButton() {
        return viewOrdersButton;
    }
}
