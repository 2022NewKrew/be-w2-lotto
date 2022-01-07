package com.david.lotto.db;

import com.david.lotto.Lotto;
import com.david.lotto.Rank;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class H2 {

    private static final String url = "jdbc:h2:./database/lotto";
    private Connection connection;


    private void connectDB() {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeDB() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createLottoTable() {
        connectDB();
        try (Statement statement = connection.createStatement()){
            String sql = "CREATE TABLE IF NOT EXISTS LOTTOS(Lotto varchar(255) NOT NULL)";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
    }

    public void createLottoResultTable() {
        connectDB();
        try (Statement statement = connection.createStatement()){
            String sql = "CREATE TABLE IF NOT EXISTS LOTTORESULTS(" +
                    "LottoRank varchar(255) NOT NULL, " +
                    "Count varchar(255) NOT NULL)";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
    }

    public void insertLotto(List<Lotto> lottoList) {
        connectDB();
        try (PreparedStatement prep = connection.prepareStatement("INSERT INTO LOTTOS VALUES(?)")){
            for (Lotto lotto : lottoList) {
                prep.setString(1,lotto.toString());
                prep.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
    }

    public void insertLottoResult(Map<Rank, Integer> totalCount) {
        connectDB();
        try (PreparedStatement prep = connection.prepareStatement("INSERT INTO LOTTORESULTS VALUES(?,?)")){
            for (Rank key : totalCount.keySet()) {
                prep.setString(1, key.getRank() + "등");
                prep.setString(2,totalCount.get(key) + "장");
                prep.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
    }
}
