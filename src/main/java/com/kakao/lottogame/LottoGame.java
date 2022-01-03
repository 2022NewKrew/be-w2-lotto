package com.kakao.lottogame;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.Money;
import com.kakao.lottogame.domain.Result;
import com.kakao.lottogame.service.LottoService;
import com.kakao.lottogame.view.InputView;
import com.kakao.lottogame.view.OutputView;
import java.util.List;

public class LottoGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void start() {
        Money money = inputView.inputMoney();
        List<Lotto> lottos = lottoService.buyLottosFor(money);
        outputView.printLottos(lottos);
        Lotto winningLotto = inputView.inputWinningLotto();
        Result result = lottoService.check(lottos, winningLotto);
        outputView.printResult(result, money);
    }
}
