package repository;

import domain.Lotto;

import java.util.List;

public interface LottoRepository {
    void save(Lotto lotto);
    List<Lotto> findAll();
    void deleteAll();
}
