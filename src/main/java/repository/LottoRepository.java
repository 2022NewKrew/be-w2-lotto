package repository;

import domain.Lotto;

import java.sql.SQLException;
import java.util.List;

public interface LottoRepository {
    Long save(Lotto lotto) throws SQLException;
    Long save(Lotto lotto, Long lottoStatisticId) throws SQLException;
    List<Lotto> findAllAsLottoStatisticId(Long id);
}
