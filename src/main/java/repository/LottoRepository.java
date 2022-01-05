package repository;

import model.Lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoRepository {
    private final Map<Long, Lotto> lottoMap = new HashMap<>();

    public Optional<Lotto> findById(Long id) {
        return Optional.of(lottoMap.get(id));
    }

    public void save(Lotto lotto) {
        lottoMap.put(lotto.getId(), lotto);
    }
}
