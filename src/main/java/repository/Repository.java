package repository;

import domain.lotto.LottoNumber;
import domain.lotto.LottoNumberContainerDTO;
import domain.lotto.LottoNumberDTO;

public interface Repository {

    void init(Long userId);

    int size(Long userId) throws Exception;

    void save(Long userId, LottoNumberDTO lottoNumberDTO) throws Exception;
    void save(Long userId, LottoNumberContainerDTO lottoNumberContainerDTO) throws Exception;

    LottoNumber get(Long userId, int i) throws Exception;
}

