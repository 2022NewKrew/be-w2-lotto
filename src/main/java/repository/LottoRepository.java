package repository;

import domain.Lotto;

import java.util.List;

public interface LottoRepository {
    Long save(List<Lotto> lottos);
}
