package repository;

import domain.LottoStatistic;

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

    @Override
    public Long save(LottoStatistic lottoStatistics) {
        return null;
    }

    @Override
    public LottoStatistic findOne(Long id) {
        return null;
    }
}
