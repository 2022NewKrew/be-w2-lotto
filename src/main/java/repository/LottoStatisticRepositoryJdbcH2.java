package repository;

import database.JdbcConnection;
import domain.LottoStatistic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LottoStatisticRepositoryJdbcH2 implements LottoStatisticRepository {

    @Override
    public Long save(LottoStatistic lottoStatistics) throws SQLException {

        Connection conn = JdbcConnection.createConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "INSERT INTO LOTTO_STATISTIC("
                + "WINNING_NUMBER_1,WINNING_NUMBER_2,WINNING_NUMBER_3,WINNING_NUMBER_4,WINNING_NUMBER_5,WINNING_NUMBER_6,"
                + "WINNING_NUMBER_BONUS,PURCHASE_COUNT,NORMAL_LOTTO_COUNT,AUTO_LOTTO_COUNT"
                + ")"
                + " VALUES (?,?,?,?,?,?,?,?,?,?)";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, lottoStatistics.getWinningNumbers().get(0) + "");
        pstmt.setString(2, lottoStatistics.getWinningNumbers().get(1) + "");
        pstmt.setString(3, lottoStatistics.getWinningNumbers().get(2) + "");
        pstmt.setString(4, lottoStatistics.getWinningNumbers().get(3) + "");
        pstmt.setString(5, lottoStatistics.getWinningNumbers().get(4) + "");
        pstmt.setString(6, lottoStatistics.getWinningNumbers().get(5) + "");
        pstmt.setString(7, lottoStatistics.getWinningBonusNumber() + "");
        pstmt.setString(8, lottoStatistics.getPurchaseCount() + "");
        pstmt.setString(9, lottoStatistics.getNormalLottoCount() + "");
        pstmt.setString(10, lottoStatistics.getAutoLottoCount() + "");

        int count = pstmt.executeUpdate();

        if (count == 0) {
            throw new SQLException("실패");
        }

        rs = pstmt.getGeneratedKeys();
        rs.next();

        return rs.getLong(1);
    }

    @Override
    public LottoStatistic findOne(Long id) throws SQLException {

        Connection conn = JdbcConnection.createConnection();
        PreparedStatement pstmt = null;

        String sql = "SELECT LOTTO_STATISTIC_ID,WINNING_NUMBER_1,WINNING_NUMBER_2,WINNING_NUMBER_3,WINNING_NUMBER_4,WINNING_NUMBER_5,WINNING_NUMBER_6,"
                + "WINNING_NUMBER_BONUS,PURCHASE_COUNT,NORMAL_LOTTO_COUNT,AUTO_LOTTO_COUNT"
                + " FROM LOTTO_STATISTIC WHERE LOTTO_STATISTIC_ID=?";

        pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1, id);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            LottoStatistic lottoStatistic = new LottoStatistic();

            lottoStatistic.setId(Long.parseLong(rs.getString("LOTTO_STATISTIC_ID")));

            List<Integer> winningNumbers = new ArrayList<>();

            winningNumbers.add(Integer.parseInt(rs.getString("WINNING_NUMBER_1")));
            winningNumbers.add(Integer.parseInt(rs.getString("WINNING_NUMBER_2")));
            winningNumbers.add(Integer.parseInt(rs.getString("WINNING_NUMBER_3")));
            winningNumbers.add(Integer.parseInt(rs.getString("WINNING_NUMBER_4")));
            winningNumbers.add(Integer.parseInt(rs.getString("WINNING_NUMBER_5")));
            winningNumbers.add(Integer.parseInt(rs.getString("WINNING_NUMBER_6")));

            lottoStatistic.setWinningNumbers(winningNumbers);
            lottoStatistic.setWinningBonusNumber(Integer.parseInt(rs.getString("WINNING_NUMBER_BONUS")));
            lottoStatistic.setPurchaseCount(Integer.parseInt(rs.getString("PURCHASE_COUNT")));
            lottoStatistic.setNormalLottoCount(Integer.parseInt(rs.getString("NORMAL_LOTTO_COUNT")));
            lottoStatistic.setAutoLottoCount(Integer.parseInt(rs.getString("AUTO_LOTTO_COUNT")));

            return lottoStatistic;
        }

        return null;
    }
}
