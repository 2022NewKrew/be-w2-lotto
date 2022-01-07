package repository;

import domain.Lotto;
import domain.LottoStatistic;

import java.sql.*;
import java.util.List;

public class LottoStatisticRepositoryJdbcH2 implements LottoStatisticRepository {

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
    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/test",
                "sa",
                "");
    }

    private ResultSet createResultSetBySQL(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public Long insertLotto(Lotto lotto) throws SQLException {
            Connection conn = createConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            String sql = "INSERT INTO LOTTO(NUMBER_1,NUMBER_2,NUMBER_3,NUMBER_4,NUMBER_5,NUMBER_6,STATUS)"
                    + " VALUES (?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, lotto.getNumbers().get(0) + "");
            pstmt.setString(2, lotto.getNumbers().get(1) + "");
            pstmt.setString(3, lotto.getNumbers().get(2) + "");
            pstmt.setString(4, lotto.getNumbers().get(3) + "");
            pstmt.setString(5, lotto.getNumbers().get(4) + "");
            pstmt.setString(6, lotto.getNumbers().get(5) + "");
            pstmt.setString(7, lotto.getStatus().toString());

            int count = pstmt.executeUpdate();

            if(count == 0) {
                throw new SQLException("실패");
            }

            rs = pstmt.getGeneratedKeys();
            rs.next();

            return rs.getLong(1);
    }

    public static void main(String[] args) {

    }

    @Override
    public Long save(LottoStatistic lottoStatistics) {

        List<Lotto> lottos = lottoStatistics.getLottos();

        return null;
    }

    @Override
    public LottoStatistic findOne(Long id) {
        return null;
    }
}
