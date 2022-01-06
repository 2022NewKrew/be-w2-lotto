package repository.dao;

import service.lotto.Lotto;
import service.lotto.LottoBundle;
import service.lotto.LottoResult;
import view.util.TypeConverter;

import java.io.Closeable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LottoDao implements Closeable {
    private Connection connection;

    public LottoDao() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:lotto");

            final Statement statement = connection.createStatement();
            final String sql = "CREATE TABLE lotto (" +
                    "id BIGINT NOT NULL, " +
                    "numbers VARCHAR(30) NOT NULL, " +
                    "result VARCHAR(50) NOT NULL " +
                    ");";
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(LottoBundle lottoBundle) {
        final long lottoId = lottoBundle.getId();
        final List<Lotto> lottoList = lottoBundle.getLottoBundle();

        for (Lotto lotto : lottoList) {
            try {
                final String sql = "INSERT INTO lotto values(?,?,?)";
                final PreparedStatement ps = connection.prepareStatement(sql);

                ps.setLong(1, lottoId);
                ps.setString(2, lotto.toString());
                ps.setString(3, lotto.getResult().toString());

                final int result = ps.executeUpdate();

                if (result == 0) {
                    throw new RuntimeException();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(LottoBundle lottoBundle) {
        final long lottoId = lottoBundle.getId();
        final List<Lotto> lottoList = lottoBundle.getLottoBundle();
        for (Lotto lotto : lottoList) {
            try {
                final String sql = "UPDATE lotto SET result = ? where (id = ? and numbers = ?)";
                final PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, lotto.getResult().name());
                ps.setLong(2, lottoId);
                ps.setString(3, lotto.toString());

                final int result = ps.executeUpdate();
                if (result == 0) {
                    throw new RuntimeException();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public LottoBundle read(long lottoId) {
        try {
            final String sql = "SELECT lt.numbers as numbers , lt.result as result " +
                    "FROM lotto as lt " +
                    "WHERE id=?";

            final PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, lottoId);

            final ResultSet result = ps.executeQuery();

            final List<Lotto> lottoList = new ArrayList<>();
            while (result.next()) {
                final String numberStr = result.getString("numbers");
                final String lottoResultStr = result.getString("result");

                final List<Integer> numbersList = TypeConverter.strToListInteger(numberStr);
                final LottoResult lottoResult = matchEnumResult(lottoResultStr);

                final Lotto lotto = new Lotto(numbersList, lottoResult);

                lottoList.add(lotto);
            }
            return new LottoBundle(lottoList, lottoId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new RuntimeException();
    }

    private LottoResult matchEnumResult(String str) {
        if (str.equals(LottoResult.UNIDENTIFIED.toString())) {
            return LottoResult.UNIDENTIFIED;
        } else if (str.equals(LottoResult.UNWINNABLE.toString())) {
            return LottoResult.UNWINNABLE;
        } else if (str.equals(LottoResult.FIFTH_PLACE.toString())) {
            return LottoResult.FIFTH_PLACE;
        } else if (str.equals(LottoResult.FOURTH_PLACE.toString())) {
            return LottoResult.FOURTH_PLACE;
        } else if (str.equals(LottoResult.THIRD_PLACE.toString())) {
            return LottoResult.THIRD_PLACE;
        } else if (str.equals(LottoResult.SECOND_PLACE.toString())) {
            return LottoResult.SECOND_PLACE;
        }
        return LottoResult.FIFTH_PLACE;
    }

    @Override
    public void close() {
        try {
            if (connection == null || connection.isClosed()) {
                return;
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
