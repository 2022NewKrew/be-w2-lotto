package repository;

import domain.Lotto;
import domain.LottoStatistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepositoryInMemory implements LottoRepository {
    static Long sequence = 0L;
    static Map<Long, LottoStatistic> inMemory = new HashMap<>();

    @Override
    public Long save(LottoStatistic lottoStatistic) {
        inMemory.put(sequence, lottoStatistic);
        //TODO: 스레드 동기화
        return sequence++;
    }

    @Override
    public LottoStatistic findOne(Long id) {
        return inMemory.get(id);
    }
}
