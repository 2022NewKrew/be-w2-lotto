package database;

import java.sql.*;

public class JdbcConnection {
    // TODO url, user, password .gitignore에 관리
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/test",
                "sa",
                "");
    }

    public static ResultSet createResultSetBySQL(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }
}
