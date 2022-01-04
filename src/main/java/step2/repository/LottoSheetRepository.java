package step2.repository;

import step2.domain.LottoSheetWithId;

public interface LottoSheetRepository<T extends LottoSheetWithId> {

    T save(T lottoSheet);
    T findByUserId(Long userId);

}
