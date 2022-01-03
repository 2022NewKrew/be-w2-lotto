package repository;

import service.lotto.Lotto;
import service.lotto.LottoBundle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepository implements Repository {
    private final Map<Long, LottoBundle> repository = new HashMap<>();

    @Override
    public void save(LottoBundle lottoBundle) {
        repository.put(lottoBundle.getId(), lottoBundle);
    }

    @Override
    public LottoBundle getLottoBundle(Long id) {
        return repository.get(id);
    }
}
