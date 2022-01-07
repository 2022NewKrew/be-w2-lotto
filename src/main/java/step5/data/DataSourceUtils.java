package step5.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceUtils {

    // DB 연결
    public static Connection getConnection(DataSource dataSource) throws SQLException {
        return DriverManager.getConnection(dataSource.URL, dataSource.USER, dataSource.PASSWORD);
    }

    // DB 연결 해제
    public static void releaseConnection(Connection conn, DataSource dataSource) throws SQLException {
        conn.close();
    }
}
