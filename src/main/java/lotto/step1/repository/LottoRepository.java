package lotto.step1.repository;

import lotto.step1.model.Lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoRepository {
    private final Map<Long, Lotto> lottoMap = new HashMap<>();

    public Optional<Lotto> findById(Long lottoId) {
        return Optional.of(lottoMap.get(lottoId));
    }

    public void save(Lotto lotto) {
        final Long id = lotto.getId();
        lottoMap.put(id, lotto);
    }

    public void update(Lotto lotto) {
        save(lotto);
    }
}