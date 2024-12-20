package org.example.controller.util;

import org.example.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {
    private static final String DATABASE_URL = "jdbc:sqlite:src/main/resources/database/data.db";

    /**
     * connects to database
     * @return connection to database
     */
    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /**
     * creates table for customer if it doesn't exist
     */
    public static void createCustomersTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS customers (
                customer_id INTEGER PRIMARY KEY AUTOINCREMENT,
                first_name TEXT NOT NULL,
                last_name TEXT NOT NULL,
                address TEXT NOT NULL,
                email TEXT NOT NULL,
                phone_number TEXT NOT NULL,
                balance DOUBLE NOT NULL
                )
                """;
        try (Connection connection = getConnection();
             Statement statement = getConnection().createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * creates table for admins if it doesn't exist
     */
    public static void createAdminsTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS admins (
                admin_id INTEGER PRIMARY KEY AUTOINCREMENT,
                first_name TEXT NOT NULL,
                last_name TEXT NOT NULL,
                email TEXT NOT NULL,
                phone_number TEXT NOT NULL
                )
                """;
        try (Connection connection = getConnection();
             Statement statement = getConnection().createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * creates drivers table
     */
    public static void createDriversTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS drivers (
                driver_id INTEGER PRIMARY KEY AUTOINCREMENT,
                first_name TEXT NOT NULL,
                last_name TEXT NOT NULL,
                email TEXT NOT NULL,
                phone_number TEXT NOT NULL
                )
                """;
        try (Connection connection = getConnection();
             Statement statement = getConnection().createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * creates orders table
     */
    public static void createOrderTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS orders (
                order_id INTEGER PRIMARY KEY AUTOINCREMENT,
                customer_id INTEGER NOT NULL,
                total_price DOUBLE NOT NULL,
                items TEXT NOT NULL,
                status TEXT NOT NULL,
                delivered_by TEXT,
                FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
                )
                """;
        try (Connection connection = getConnection();
             Statement statement = getConnection().createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * creates items table
     */
    public static void createFoodItemTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS items (
                item_id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                price DOUBLE NOT NULL
                )
                """;
        try (Connection connection = getConnection();
             Statement statement = getConnection().createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * insert into customers table
     * @param firstName first name of customer
     * @param lastName last name of customer
     * @param email email of customer
     * @param phoneNumber phone number of customer
     */
    public static void insertRecordsCustomers(String firstName, String lastName, String email, String phoneNumber, Address address, double balance) {
        String sql = """
                INSERT INTO customers(first_name, last_name, address, email, phone_number, balance) VALUES (?, ?, ?, ?, ?, ?)""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, address.toString());
            statement.setString(4, email);
            statement.setString(5, phoneNumber);
            statement.setDouble(6, balance);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * adds the records in customers table
     * @param customer the customer to be inserted
     */
    public static void insertRecordsCustomers(Customer customer) {
        String firstName = customer.getfName();
        String lastName = customer.getlName();
        String email = customer.getEmail();
        String phoneNumber = customer.getPhoneNumber();
        Address address = customer.getAddress();
        double balance = customer.getBalance();
        insertRecordsCustomers(firstName,lastName,email,phoneNumber, address,balance);
    }

    /**
     * insert into admins table

     * @param fName first name of admin
     * @param lName last name of admin
     * @param phoneNumber phone number of admin
     * @param email email of admin
     */
    public static void insertRecordsAdmins(String fName, String lName, String phoneNumber, String email) {
        String sql = """
                INSERT INTO admins(first_name, last_name, phone_number, email) VALUES (?, ?, ?, ?)""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fName);
            statement.setString(2, lName);
            statement.setString(3, email);
            statement.setString(4, phoneNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Inserts records into admins table
     * @param admin the admin to be inserted
     */
    public static void insertRecordsAdmins(Admin admin) {
        String firstName = admin.getfName();
        String lastName = admin.getlName();
        String email = admin.getEmail();
        String phoneNumber = admin.getPhoneNumber();
        insertRecordsAdmins(firstName, lastName, email, phoneNumber);
    }

    public static void insertRecordsDrivers(String fName, String lName, String phoneNumber, String email) {
        String sql = """
                INSERT INTO drivers(first_name, last_name, phone_number, email) VALUES (?, ?, ?, ?)""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fName);
            statement.setString(2, lName);
            statement.setString(3, email);
            statement.setString(4, phoneNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Inserts records into drivers table
     * @param userDriver the driver to be inserted
     */
    public static void insertRecordsDrivers(UserDriver userDriver) {
        String firstName = userDriver.getfName();
        String lastName = userDriver.getlName();
        String email = userDriver.getEmail();
        String phoneNumber = userDriver.getPhoneNumber();
        insertRecordsDrivers(firstName, lastName, email, phoneNumber);
    }

    /**
     * Insert records into orders table
     * @param customerId id of customer
     * @param totalPrice price of order, all items
     * @param items all the food items
     * @param status processing status of order
     */
    public static void insertRecordsOrders(int customerId, double totalPrice , String items, String status) {
        String sql = """
                INSERT INTO orders(customer_id, total_price, items, status) VALUES (?, ?, ?, ?)""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerId);
            statement.setDouble(2, totalPrice);
            statement.setString(3, items);
            statement.setString(4, status);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * insert records into orders table
     * @param order order to insert
     */
    public static void insertRecordsOrders(Order order) {
        int customerId = order.getCustomer().getCustomerId();
        double totalPrice = order.getPrice();
        String items = order.getItems().toString();
        String status = order.getProcessStatus();
        insertRecordsOrders(customerId, totalPrice, items, status);
    }

    /**
     * insert into items table
     * @param name name of item
     * @param price price of item
     */
    public static void insertRecordsItems(String name, double price) {
        String sql = """
                INSERT INTO items(name, price) VALUES (?, ?)""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * insert into items table
     * @param item item to insert
     */
    public static void insertRecordsItems(FoodItem item) {
        String itemName = item.getName();
        double price = item.getPrice();
        insertRecordsItems(itemName, price);
    }

    /**
     * query all customers into a list
     * @return the list of all customers
     */
    public static List<Customer> queryAllCustomers() {
        String sql = """
                SELECT * FROM customers""";
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql);)
        {
            while (resultSet.next()) {
                int customerId = resultSet.getInt( "customer_id");
                String firstName = resultSet.getString( "first_name");
                String lastName= resultSet.getString( "last_name");
                String address = resultSet.getString( "address");
                String email = resultSet.getString( "email");
                String phoneNumber = resultSet.getString( "phone_number");
                double balance = resultSet.getDouble( "balance");

                customers.add(new Customer(customerId, firstName, lastName, email, phoneNumber, balance, address));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    /**
     * query all admins into a list
     * @return the list of all admins
     */
    public static List<Admin> queryAllAdmins() {
        String sql = """
                SELECT * FROM admins """;
        List<Admin> admins = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql);)
        {
            while (resultSet.next()) {
                int adminId = resultSet.getInt( "admin_id");
                String firstName = resultSet.getString( "first_name");
                String lastName= resultSet.getString( "last_name");
                String email = resultSet.getString( "email");
                String phoneNumber = resultSet.getString( "phone_number");
                admins.add(new Admin(adminId, firstName, lastName, email, phoneNumber));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admins;
    }

    /**
     * query all drivers
     * @return list of all drivers
     */
    public static List<UserDriver> queryAllDrivers() {
        String sql = """
                SELECT * FROM drivers """;
        List<UserDriver> drivers = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql);)
        {
            while (resultSet.next()) {
                int userDriverId = resultSet.getInt( "driver_id");
                String firstName = resultSet.getString( "first_name");
                String lastName= resultSet.getString( "last_name");
                String email = resultSet.getString( "email");
                String phoneNumber = resultSet.getString( "phone_number");
                drivers.add(new UserDriver(userDriverId, firstName, lastName, email, phoneNumber));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return drivers;
    }

    /**
     * query all orders
     * @return list of all orders
     */
    public static List<Order> queryAllOrders() {
        String sql = """
                SELECT * FROM orders """;
        List<Order> orders = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql);)
        {
            while (resultSet.next()) {
                int orderId = resultSet.getInt( "order_id");
                int customerId = resultSet.getInt( "customer_id");
                double totalPrice= resultSet.getDouble( "total_price");
                String items = resultSet.getString( "items");
                String status = resultSet.getString( "status");
                orders.add(new Order(orderId, customerId, totalPrice, items, status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    /**
     * query orders by specified customer id
     * @param customerId customer id to query
     * @return list of orders with the customer id specified
     */
    public static List<Order> queryOrdersByCustomerId(int customerId) {
        String sql = """
            SELECT * FROM orders WHERE customer_id = ?
            """;
        List<Order> orders = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                double totalPrice = resultSet.getDouble("total_price");
                String items = resultSet.getString("items");
                String status = resultSet.getString("status");
                orders.add(new Order(orderId, customerId, totalPrice, items, status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    /**
     * query all orders with status 'Processed'
     * @return List of orders with status 'Processed'
     */
    public static List<Order> queryProcessedOrders() {
    String sql = """
            SELECT * FROM orders WHERE status = 'Processed'""";
        List<Order> orders = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql);)
        {
            while (resultSet.next()) {
                int orderId = resultSet.getInt( "order_id");
                int customerId = resultSet.getInt( "customer_id");
                double totalPrice= resultSet.getDouble( "total_price");
                String items = resultSet.getString( "items");
                String status = resultSet.getString( "status");
                orders.add(new Order(orderId, customerId, totalPrice, items, status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    /**
     * query all items
     * @return list of all items
     */
    public static List<FoodItem> queryAllItems() {
        String sql = """
                SELECT * FROM items """;
        List<FoodItem> foodItems = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql);)
        {
            while (resultSet.next()) {
                int itemId = resultSet.getInt( "item_id");
                String name = resultSet.getString( "name");
                double price= resultSet.getDouble( "price");

                foodItems.add(new FoodItem(itemId, name, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foodItems;
    }

    /**
     * removes order with corresponding id
     * @param orderId order to remove
     */
    public static void deleteOrder(int orderId) {
        String sql = "DELETE FROM orders WHERE order_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * update customer balance
     * @param customerId customer to update
     * @param newBalance updated balance
     */
    public static void updateCustomerBalance(int customerId, double newBalance) {
        String sql = "UPDATE customers SET balance = ? WHERE customer_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, newBalance);
            statement.setInt(2, customerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * update order status of an order
     * @param orderId order to update status
     * @param status status to change
     */
    public static void updateOrderStatus(int orderId, String status) {
        String sql = "UPDATE orders SET status = ? WHERE order_id = ?";

        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, status);
            statement.setInt(2, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void  updateDeliveredBy(int orderId, String deliveredBy) {
        String sql = "UPDATE orders SET delivered_by = ? WHERE order_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, deliveredBy);
            statement.setInt(2, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
