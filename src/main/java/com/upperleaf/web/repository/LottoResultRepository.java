package com.upperleaf.web.repository;

import com.google.gson.Gson;
import com.upperleaf.domain.LottoResult;
import com.upperleaf.web.db.ConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class LottoResultRepository {

    private final Gson gson = new Gson();
    private final Logger logger = LoggerFactory.getLogger(LottoResultRepository.class);

    public LottoResult saveLottoResult(LottoResult lottoResult) throws SQLException {
        Connection conn = ConnectionProvider.getConnection();
        PreparedStatement statement = makeInsertQuery(conn, lottoResult);
        statement.executeUpdate();
        lottoResult.setId(getGeneratedId(statement));
        logger.info("로또 결과 저장 - 로또 결과 ID : {}, 수익률 : {}", lottoResult.getId(), lottoResult.getProfitRate());
        conn.close();
        return lottoResult;
    }

    private PreparedStatement makeInsertQuery(Connection conn, LottoResult lottoResult) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO LOTTOS_RESULT(lotto_id, match_result, profit_rate) VALUES (?, ? FORMAT JSON, ?)", Statement.RETURN_GENERATED_KEYS);
        String matchResult = gson.toJson(lottoResult.getGroupLottoRanking());
        statement.setLong(1, lottoResult.getLottosId());
        statement.setString(2, matchResult);
        statement.setLong(3, lottoResult.getProfitRate());
        return statement;
    }

    private Long getGeneratedId(PreparedStatement statement) throws SQLException {
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if(generatedKeys.next()) {
            return generatedKeys.getLong(1);
        }
        throw new SQLException("생성된 ID가 없습니다");
    }
}
