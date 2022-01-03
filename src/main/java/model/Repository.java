package model;

import model.datastructure.LottoNumber;
import model.datastructure.LottoNumbersContainer;

public interface Repository {

    void init(Long userId);

    int size(Long userId) throws Exception;

    int save(Long userId, LottoNumber lottoNumber);

    LottoNumber get(Long userId, int i) throws Exception;
}

