package lottery.domain.lotteries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LotteryRepository {

    private final String JDBC_DRIVER;
    private final String DB_URL;
    private long id = 0;
    private Connection conn;

    public LotteryRepository() {
        JDBC_DRIVER = "org.h2.Driver";
        DB_URL = "jdbc:h2:mem:~/test";

        try {
            conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            final String sql = "CREATE TABLE lotto (" +
                    "id BIGINT NOT NULL, " +
                    "numbers VARCHAR(30) NOT NULL" +
                    ");";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(LotteryEntity lotteryEntity) {
        try {
            Statement statement = conn.createStatement();
            final String sql = "INSERT INTO lotto values(?, ?)";
            final PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id++);
            ps.setString(2, lotteryEntity.toString());

            final int result = ps.executeUpdate();

            if (result == 0) {
                throw new RuntimeException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<LotteryEntity> findAll() {
        ArrayList<LotteryEntity> lotteryEntityList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            final String sql = "SELECT * FROM lotto";
            final PreparedStatement ps = conn.prepareStatement(sql);

            final ResultSet result = ps.executeQuery();

            while (result.next()) {
                String numbers = result.getString("numbers");
                String[] parsedNumber = numbers.split(",");
                List<Integer> lotteryNumber = new ArrayList<>();
                for(String num : parsedNumber) {
                    lotteryNumber.add(Integer.parseInt(num));
                }
                lotteryEntityList.add(new LotteryEntity(lotteryNumber));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lotteryEntityList;
    }

}
