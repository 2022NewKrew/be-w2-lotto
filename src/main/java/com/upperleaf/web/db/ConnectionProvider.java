package com.upperleaf.web.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.upperleaf.web.db.H2DatabaseInitializer.*;

public class ConnectionProvider {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
    }
}
