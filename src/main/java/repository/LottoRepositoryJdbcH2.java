package repository;

import domain.LottoStatistic;

import java.sql.*;

public class LottoRepositoryJdbcH2 implements LottoRepository {

//    try {
//
//        Class.forName("org.h2.Driver");
//
//        Connection conn = DriverManager.getConnection(
//                "jdbc:h2:tcp://localhost/~/test",
//                "sa",
//                ""
//        );
//
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "SELECT * FROM MEMBER"
//        );
//
//        while (rs.next()) {
//            System.out.println(rs.next());
//        }
//        conn.close();
//    } catch (SQLException | ClassNotFoundException e) {
//        e.printStackTrace();
//    }

    // TODO url, user, password .gitignore에 관리
    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/test",
                "sa",
                "");
    }

    private ResultSet createResultSetBySQL(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    @Override
    public Long save(LottoStatistic LottoStatistics) {
        return null;
    }

    @Override
    public LottoStatistic findOne(Long id) {
        return null;
    }
}
