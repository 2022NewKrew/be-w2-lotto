package lotto.view;


import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public interface LottoView {

    String printLottos(Lottos lottos);
    String printLottoResult(LottoResult lottoResult, float totalRateOfReturn);
    String printError(String message);
}

