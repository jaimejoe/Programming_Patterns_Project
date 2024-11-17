package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
    public static final String BASE_PATH = "jdbc:sqlite:./src/main/resources/database/";
    public static final String DB_PATH = BASE_PATH + "data.db";

    public static final String CREATE_USER_TABLE_SQL = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY,
                fName TEXT NOT NULL,
                lName TEXT NOT NULL,
                phoneNumber TEXT NOT NULL,
                email TEXT NOT NULL,
                address TEXT NOT NULL
                )
            """;

    public static final String CREATE_ITEMS_TABLE_SQL = """
            CREATE TABLE IF NOT EXISTS items (
                id INTEGER PRIMARY KEY,
                name TEXT NOT NULL,
                price DECIMAL NOT NULL
                )
            """;

    public static final String CREATE_ORDERS_TABLE_SQL = """
            CREATE TABLE IF NOT EXISTS orders (
                id INTEGER PRIMARY KEY,
                userId INTEGER,
                price DECIMAL NOT NULL,
                processStatus BOOLEAN NOT NULL,
                dateCreated TIMESTAMP NOT NULL,
                FOREIGN KEY (userId) REFERENCES users(id)
                )
            """;

    public static final String DROP_USERS_TABLE = """
            DROP TABLE IF EXISTS users
            """;


    /**
     * connects to a local db file
     *
     * @param path the path of a local db file
     * @return the connection to the local db file
     */
    public static Connection connect(String path) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(path);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /**
     * creates a new table in a local database
     *
     * @param sql the sql statement to create the new table
     */
    public static void createTable(String sql) {
        if (!sql.toUpperCase().contains("CREATE")) {
            System.out.println("creating table failed: sql statement must contain keyword CREATE");
            return;
        }

        executeDdlAndDml(sql);
    }

    /**
     * alter an existing table in a local database
     *
     * @param sql the sql statement to alter an existing table
     */
    public static void alterTable(String sql) {
        if (!sql.toUpperCase().contains("ALTER")) {
            System.out.println("altering table failed: sql statement must contain keyword ALTER");
            return;
        }

        executeDdlAndDml(sql);
    }

    /**
     * drop an existing table in a local database
     * @param sql the sql statement to drop an existing table
     */
    public static void dropTable(String sql) {
        if (!sql.toUpperCase().contains("DROP")) {
            System.out.println("dropping table failed: sql statement must contain keyword DROP");
            return;
        }

        executeDdlAndDml(sql);
    }

    /**
     * inserts record into an existing table in a local database
     *
     * @param sql the sql statement to insert record to an existing table
     */
    public static void insertRecord(String sql) {
        if (!sql.toUpperCase().contains("INSERT INTO")) {
            System.out.println("inserting record failed: sql statement must contain keyword INSERT INTO");
            return;
        }

        executeDdlAndDml(sql);
    }

    /**
     * updates a record in an existing table in a local database
     *
     * @param sql the sql statement to update a record in an existing table
     */
    public static void updateRecord(String sql) {
        if (!sql.toUpperCase().contains("UPDATE")) {
            System.out.println("updating record failed: sql statement must contain keyword UPDATE");
            return;
        }

        executeDdlAndDml(sql);
    }

    private static void executeDdlAndDml(String sql) {
        try (Connection connection = connect(DB_PATH);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
