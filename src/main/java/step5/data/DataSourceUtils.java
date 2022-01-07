package step5.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceUtils {

    public static Connection getConnection(DataSource dataSource) throws SQLException {
        return DriverManager.getConnection(dataSource.URL, dataSource.USER, dataSource.PASSWORD);
    }

    public static void releaseConnection(Connection conn, DataSource dataSource) throws SQLException {
        conn.close();
    }
}
