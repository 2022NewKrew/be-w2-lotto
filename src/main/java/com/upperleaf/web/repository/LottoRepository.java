package com.upperleaf.web.repository;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.upperleaf.domain.lotto.Lottos;
import com.upperleaf.domain.lotto.create.ManualLottoStrategy;
import com.upperleaf.web.db.ConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;

public class LottoRepository {

    private final Logger logger = LoggerFactory.getLogger(LottoRepository.class);
    private final Gson gson = new Gson();

    public Lottos saveLottos(Lottos lottos) throws SQLException {
        Connection conn = ConnectionProvider.getConnection();
        PreparedStatement statement = makeLottoInsertQuery(conn, lottos);
        statement.executeUpdate();
        lottos.setId(getGeneratedId(statement));
        logger.info("로또 저장 - 로또 ID : {}, 로또 크기 : {}", lottos.getId(), lottos.getLottosSize());
        conn.close();
        return lottos;
    }

    public Lottos findById(Long lottoId) throws SQLException {
        Connection conn = ConnectionProvider.getConnection();
        PreparedStatement statement = makeLottoSelectQuery(conn, lottoId);
        ResultSet resultSet = statement.executeQuery();
        Lottos lottos = createLottosByResultSet(resultSet);
        conn.close();
        return lottos;
    }

    private PreparedStatement makeLottoInsertQuery(Connection conn, Lottos lottos) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO LOTTOS(lottos, lottos_size) VALUES (? FORMAT JSON, ?)", Statement.RETURN_GENERATED_KEYS);
        String lottosInfo = gson.toJson(lottos.getLottoNumbers());
        statement.setString(1, lottosInfo);
        statement.setLong(2, lottos.getLottosSize());
        return statement;
    }

    private PreparedStatement makeLottoSelectQuery(Connection conn, Long lottoId) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM LOTTOS WHERE id = ?");
        statement.setLong(1, lottoId);
        return statement;
    }

    private Lottos createLottosByResultSet(ResultSet resultSet) throws SQLException {
        Lottos lottos = null;
        if(resultSet.next()) {
            String lottoString = resultSet.getString("lottos");
            List<List<Integer>> lottoNumbers = gson.fromJson(lottoString, new TypeToken<List<List<Integer>>>(){}.getType());
            lottos = Lottos.createLottos(resultSet.getLong("lottos_size"), new ManualLottoStrategy(lottoNumbers));
            lottos.setId(resultSet.getLong("id"));
        }
        return lottos;
    }

    private Long getGeneratedId(PreparedStatement statement) throws SQLException {
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if(generatedKeys.next()) {
            return generatedKeys.getLong(1);
        }
        throw new SQLException("생성된 ID가 없습니다");
    }
}
