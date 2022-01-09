package lotto;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class DBController {
    private static final String embeddedJdbcDriver = "jdbc:h2:/Users/kakao/IdeaProjects/be-w2-lotto/lotto";

    public void createTables() {
        try (Connection conn = DriverManager.getConnection(embeddedJdbcDriver, "", "");
             Statement stmt = conn.createStatement()){
            Class.forName("org.h2.Driver");
            final String createLottoTableSql =
                    "CREATE TABLE IF NOT EXISTS LOTTO " +
                            "(ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                            " NUM1 INT," +
                            " NUM2 INT," +
                            " NUM3 INT," +
                            " NUM4 INT," +
                            " NUM5 INT," +
                            " NUM6 INT)";
            stmt.executeUpdate(createLottoTableSql);
            final String createWinningTableSql =
                    "CREATE TABLE IF NOT EXISTS WINNING " +
                            "(ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                            "RANK1 INT, " +
                            "RANK2 INT, " +
                            "RANK3 INT, " +
                            "RANK4 INT, " +
                            "RANK5 INT)";
            stmt.executeUpdate(createWinningTableSql);
            conn.commit();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }

    public void insertAllLottos(List<UserLotto> lottos) {
        for (UserLotto lotto: lottos) {
            insertLotto(lotto);
        }
    }

    private void insertLotto(UserLotto lotto) {
        final String insertString = "INSERT INTO LOTTO(NUM1, NUM2, NUM3, NUM4, NUM5, NUM6) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(embeddedJdbcDriver, "", "");
            PreparedStatement ps = conn.prepareStatement(insertString)) {
            Class.forName("org.h2.Driver");
            for (int i = 0; i < 6; i++) {
                ps.setInt(i + 1, lotto.getLottoNumbers().get(i).getNumber());
            }
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }

    public void insertRankCount(RankCount rankCount) {
        final String insertString = "INSERT INTO WINNING(RANK1, RANK2, RANK3, RANK4, RANK5) VALUES(?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection(embeddedJdbcDriver, "", "");
            PreparedStatement ps = conn.prepareStatement(insertString)) {
            Class.forName("org.h2.Driver");
            for (int i = 0; i < 5; i++) {
                ps.setInt(i + 1, rankCount.getRankCount(i));
            }
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }

    public void printLottoTable() {
        final String selectString = "SELECT * FROM LOTTO";
        try (Connection conn = DriverManager.getConnection(embeddedJdbcDriver, "", "");
            Statement stmt = conn.createStatement()) {
            Class.forName("org.h2.Driver");
            ResultSet rs = stmt.executeQuery(selectString);
            System.out.println("Lotto");
            while(rs.next()) {
                System.out.println(Arrays.asList(rs.getInt("NUM1"), rs.getInt("NUM2"), rs.getInt("NUM3"), rs.getInt("NUM4"), rs.getInt("NUM5"), rs.getInt("NUM6")));
            }
            conn.commit();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }

    public void printWinningTable() {
        final String selectString = "SELECT * FROM WINNING";
        try (Connection conn = DriverManager.getConnection(embeddedJdbcDriver, "", "");
            Statement stmt = conn.createStatement()) {
            Class.forName("org.h2.Driver");
            ResultSet rs = stmt.executeQuery(selectString);
            System.out.println("Winning");
            while(rs.next()) {
                System.out.println(Arrays.asList(rs.getInt("RANK1"), rs.getInt("RANK2"), rs.getInt("RANK3"), rs.getInt("RANK4"), rs.getInt("RANK5")));
            }
            conn.commit();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }
}
