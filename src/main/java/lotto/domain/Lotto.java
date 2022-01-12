package lotto.domain;

import lotto.collections.LottoLine;
import lotto.utils.LottoNumberPool;

public class Lotto {


    public LottoLine getRandLotto() {
        LottoLine lottoLine = LottoNumberPool.getSixNumbers();
        return lottoLine;
    }


}
