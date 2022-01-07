package repository;

import domain.LottoStatistic;

import java.util.HashMap;
import java.util.Map;

/**
 * LottoRepository 인터페이스의 HashMap 으로 만든 구현체입니다.
 * @author jm.hong
 */
public class LottoStatisticRepositoryInMemory implements LottoStatisticRepository {
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
