package repository;

import service.lotto.LottoBundle;

public interface Repository {
    void save(LottoBundle lottoBundle);

    LottoBundle findById(Long id);

    void update(LottoBundle lottoBundle);
}
