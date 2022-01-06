package repository;

import domain.Lotto;
import domain.LottoStatistic;

import java.util.List;

public interface LottoRepository {
    Long save(LottoStatistic LottoStatistics);

    LottoStatistic findOne(Long id);
}
