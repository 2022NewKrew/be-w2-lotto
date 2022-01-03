package repository;

import service.lotto.LottoBundle;

public interface Repository {
    void save(LottoBundle lottoBundle);
    LottoBundle getLottoBundle(Long id);
}
