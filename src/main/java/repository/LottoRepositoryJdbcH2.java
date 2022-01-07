package repository;

import common.LottoWinningStatus;
import database.JdbcConnection;
import domain.Lotto;
import domain.LottoAuto;
import domain.LottoNormal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LottoRepositoryJdbcH2 implements LottoRepository {

    @Override
    public Long save(Lotto lotto, Long lottoStatisticId) throws SQLException {
        Connection conn = JdbcConnection.createConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "INSERT INTO LOTTO(LOTTO_STATISTIC_ID,NUMBER_1,NUMBER_2,NUMBER_3,NUMBER_4,NUMBER_5,NUMBER_6,STATUS)"
                + " VALUES (?,?,?,?,?,?,?,?)";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, lottoStatisticId + "");
        pstmt.setString(2, lotto.getNumbers().get(0) + "");
        pstmt.setString(3, lotto.getNumbers().get(1) + "");
        pstmt.setString(4, lotto.getNumbers().get(2) + "");
        pstmt.setString(5, lotto.getNumbers().get(3) + "");
        pstmt.setString(6, lotto.getNumbers().get(4) + "");
        pstmt.setString(7, lotto.getNumbers().get(5) + "");
        pstmt.setString(8, lotto.getStatus().toString());

        int count = pstmt.executeUpdate();

        if (count == 0) {
            throw new SQLException("실패");
        }

        rs = pstmt.getGeneratedKeys();
        rs.next();

        return rs.getLong(1);
    }

    public Long save(Lotto lotto) throws SQLException {
        Connection conn = JdbcConnection.createConnection();
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

        if (count == 0) {
            throw new SQLException("실패");
        }

        rs = pstmt.getGeneratedKeys();
        rs.next();

        return rs.getLong(1);
    }

    @Override
    public List<Lotto> findAllAsLottoStatisticId(Long id) {
        try {
            Connection conn = JdbcConnection.createConnection();
            PreparedStatement pstmt = null;

            String sql = "SELECT LOTTO_ID,LOTTO_STATISTIC_ID,NUMBER_1,NUMBER_2,NUMBER_3,NUMBER_4,NUMBER_5,NUMBER_6,STATUS"
                    + " FROM LOTTO WHERE LOTTO_STATISTIC_ID=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);

            ResultSet rs = pstmt.executeQuery();

            List<Lotto> lottos = new ArrayList<>();
            while(rs.next()) {
                List<Integer> numbers = new ArrayList<>();
                numbers.add(Integer.valueOf(rs.getString("NUMBER_1")));
                numbers.add(Integer.valueOf(rs.getString("NUMBER_2")));
                numbers.add(Integer.valueOf(rs.getString("NUMBER_3")));
                numbers.add(Integer.valueOf(rs.getString("NUMBER_4")));
                numbers.add(Integer.valueOf(rs.getString("NUMBER_5")));
                numbers.add(Integer.valueOf(rs.getString("NUMBER_6")));
                Lotto lotto = new LottoNormal(numbers);
                lotto.setId(rs.getLong("LOTTO_ID"));
                lotto.setStatus(LottoWinningStatus.valueOf(rs.getString("STATUS")));
                lottos.add(lotto);
            }

            return lottos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
