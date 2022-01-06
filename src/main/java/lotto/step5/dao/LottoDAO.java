package lotto.step5.dao;

import lotto.step1.model.Lotto;
import lotto.step1.model.LottoNumbers;
import lotto.step1.model.LottoResult;
import lotto.step1.util.TypeConverter;
import lotto.step1.util.Validator;
import lotto.step2.model.LottoAddBonusBall;
import lotto.step2.model.LottoNumbersAddBonusBall;

import java.io.Closeable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LottoDAO implements Closeable {
    protected Connection connection;

    public LottoDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:lotto");

            final Statement statement = connection.createStatement();
            final String sql = "CREATE TABLE lotto (" +
                    "id BIGINT NOT NULL, " +
                    "numbers VARCHAR(30) NOT NULL, " +
                    "result VARCHAR(10) NOT NULL " +
                    ");";

            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(Lotto lotto) {
        final long lottoId = lotto.getId();
        final List<LottoNumbers> lottoNumbersList = lotto.getPurchasedLottoNumbersList();

        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            try {
                final String sql = "INSERT INTO lotto values(?,?,?)";
                final PreparedStatement ps = connection.prepareStatement(sql);

                ps.setLong(1, lottoId);
                ps.setString(2, lottoNumbers.toString());
                ps.setString(3, lottoNumbers.getResult().toString());

                final int result = ps.executeUpdate();

                if (result == 0) {
                    throw new RuntimeException();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Lotto lotto) {
        final long lottoId = lotto.getId();
        final List<LottoNumbers> lottoNumbersList = lotto.getPurchasedLottoNumbersList();

        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            try {
                final String sql = "UPDATE lotto SET result = ? where (id = ? and numbers = ?)";
                final PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, lottoNumbers.getResult().name());
                ps.setLong(2, lottoId);
                ps.setString(3, lottoNumbers.toString());

                final int result = ps.executeUpdate();

                if (result == 0) {
                    throw new RuntimeException();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Lotto read(long lottoId) {
        try {
            final String sql = "SELECT lt.numbers as numbers , lt.result as result " +
                    "FROM lotto as lt " +
                    "WHERE id=?";

            final PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, lottoId);

            final ResultSet result = ps.executeQuery();

            final List<LottoNumbers> lottoNumbersList = new ArrayList<>();
            while (result.next()) {
                final String numbersStr = result.getString("numbers");
                final String lottoResultStr = result.getString("result");

                final List<Integer> numbersList = TypeConverter.strToIntList(numbersStr, Validator.FROM_1_TO_45_VALIDATOR);
                final LottoResult lottoResult = LottoResult.valueOf(lottoResultStr);

                final LottoNumbers lottoNumbers = new LottoNumbersAddBonusBall(numbersList, lottoResult);

                lottoNumbersList.add(lottoNumbers);
            }

            return new LottoAddBonusBall(lottoId, lottoNumbersList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new RuntimeException();
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
