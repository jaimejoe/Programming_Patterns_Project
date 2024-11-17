package org.example.view;

import org.example.view.customerview.customerViewForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrameForm extends JFrame {
    private JButton customerButton;
    private JButton adminButton;
    private JButton driverButton;
    private JPanel mainPanel;

    public mainFrameForm() throws HeadlessException {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new customerViewForm().setVisible(true);
            }
        });
    }
}
