package com.upperleaf.web.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DatabaseInitializer {
    public static final String JDBC_URL = "jdbc:h2:mem:lottodb;";
    public static final String CLOSE_DELAY = "DB_CLOSE_DELAY=-1;";
    public static final String INIT_SQL = "INIT=RUNSCRIPT FROM 'classpath:/sql/init.sql';";
    public static final String USER_NAME = "sa";
    public static final String PASSWORD = "";

    public static void initialize() throws SQLException {
        Connection conn = DriverManager.getConnection(JDBC_URL + CLOSE_DELAY + INIT_SQL, USER_NAME, PASSWORD);
        conn.close();
    }
}
