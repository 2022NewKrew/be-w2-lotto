package step5.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Repository {
    default void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void closePreparedStatement(PreparedStatement pstmt) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        closeConnection(conn);
        closePreparedStatement(pstmt);
        closeResultSet(rs);
    }

    default void close(Connection conn, PreparedStatement pstmt) {
        closeConnection(conn);
        closePreparedStatement(pstmt);
    }
}
