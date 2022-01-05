package repository;

import service.lotto.LottoBundle;

import java.util.HashMap;
import java.util.Map;

public class InMemoryLottoRepository implements Repository {
    private static final Map<Long, LottoBundle> repository = new HashMap<>();

    @Override
    public void save(LottoBundle lottoBundle) {
        final Long id = lottoBundle.getId();
        repository.put(id, lottoBundle);
    }

    @Override
    public LottoBundle getLottoBundle(Long id) {
        return repository.get(id);
    }
}
