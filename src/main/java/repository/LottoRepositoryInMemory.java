package repository;

import domain.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepositoryInMemory implements LottoRepository {
    static Long sequence = 0L;
    static Map<Long, List<Lotto>> inMemory = new HashMap<>();

    @Override
    public Long save(List<Lotto> lottos) {
        inMemory.put(sequence, lottos);
        //TODO: 스레드 동기화
        return sequence++;
    }
}
