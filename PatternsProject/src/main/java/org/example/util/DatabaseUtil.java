package org.example.util;

import org.example.model.Address;
import org.example.model.Admin;
import org.example.model.Customer;
import org.example.model.UserDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {
    private static final String DATABASE_URL = "jdbc:sqlite:.src/main/resources/school.db";;

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
                customer_id INTEGER NOT NULL PRIMARY KEY,
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
                CREATE TABLE IF NOT EXISTS customers (
                admin_id INTEGER NOT NULL PRIMARY KEY,
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

    public static void createDriversTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                driver_id INTEGER NOT NULL PRIMARY KEY,
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

    public static void createOrderTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS orders (
                order_id INTEGER NOT NULL PRIMARY KEY,
                customer_id INTEGER NOT NULL,
                total_price DOUBLE NOT NULL,
                items TEXT NOT NULL,
                status TEXT NOT NULL,
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
     * insert into customers table
     * @param customerId
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     */
    public static void insertRecordsCustomers(int customerId, String firstName, String lastName, String email, String phoneNumber, String address, double balance) {
        String sql = """
                INSERT INTO customers(customer_id, first_name, last_name, address, email, phone_number, balance) VALUES (?, ?, ?, ?, ?, ?, ?)""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerId);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, address.toString());
            statement.setString(5, email);
            statement.setString(6, phoneNumber);
            statement.setDouble(7, balance);
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
        int customerId = customer.getCustomerId();
        String firstName = customer.getfName();
        String lastName = customer.getlName();
        String email = customer.getEmail();
        String phoneNumber = customer.getPhoneNumber();
        String address = customer.getAddress();
        double balance = customer.getBalance();
        insertRecordsCustomers(customerId,firstName,lastName,email,phoneNumber, address,balance);
    }

    /**
     * insert into admins table
     * @param adminId
     * @param fName
     * @param lName
     * @param phoneNumber
     * @param email
     */
    public static void insertRecordsAdmins(int adminId, String fName, String lName, String phoneNumber, String email) {
        String sql = """
                INSERT INTO students(admin_id, first_name, last_name, phone_number, email) VALUES (?, ?, ?, ?, ?)""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, adminId);
            statement.setString(2, fName);
            statement.setString(3, lName);
            statement.setString(4, email);
            statement.setString(5, phoneNumber);
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
        int adminId = admin.getAdminId();
        String firstName = admin.getfName();
        String lastName = admin.getlName();
        String email = admin.getEmail();
        String phoneNumber = admin.getPhoneNumber();
        insertRecordsAdmins(adminId, firstName, lastName, email, phoneNumber);
    }

    public static void insertRecordsDrivers(int driverId, String fName, String lName, String phoneNumber, String email) {
        String sql = """
                INSERT INTO students(admin_id, first_name, last_name, phone_number, email) VALUES (?, ?, ?, ?, ?)""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, driverId);
            statement.setString(2, fName);
            statement.setString(3, lName);
            statement.setString(4, email);
            statement.setString(5, phoneNumber);
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
        int userDriverId = userDriver.getDriverId();
        String firstName = userDriver.getfName();
        String lastName = userDriver.getlName();
        String email = userDriver.getEmail();
        String phoneNumber = userDriver.getPhoneNumber();
        insertRecordsDrivers(userDriverId, firstName, lastName, email, phoneNumber);
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

                customers.add(new Customer(customerId, firstName, lastName, address, email, phoneNumber, balance));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    /**
     * query all admims into a list
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

}
