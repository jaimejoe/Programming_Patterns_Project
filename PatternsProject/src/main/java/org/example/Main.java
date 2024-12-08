package org.example;

import org.example.view.MainFrameForm;

import static org.example.util.DatabaseUtil.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //createTable(CREATE_USER_TABLE_SQL);
//        createTable(CREATE_ITEMS_TABLE_SQL);
//        createTable(CREATE_ORDERS_TABLE_SQL);
        MainFrameForm view = new MainFrameForm();
    }
}