package com.kakao.lottogame;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.Money;
import com.kakao.lottogame.domain.Result;
import com.kakao.lottogame.domain.WinningLotto;
import com.kakao.lottogame.service.LottoService;
import com.kakao.lottogame.view.InputView;
import com.kakao.lottogame.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    private Money money;
    private int manualLottoNum;
    private int autoLottoNum;

    public void start() {
        buyLottos();

        outputView.printManualInfo();
        List<Lotto> lottos = generateLottos(manualLottoNum, autoLottoNum);

        outputView.printLottos(lottos, manualLottoNum, autoLottoNum);
        WinningLotto winningLotto = lottoService.generateWinningLotto(inputView.inputWinningLotto(),
            inputView.inputBonusNumber());

        Result result = lottoService.collate(lottos, winningLotto);
        outputView.printResult(result, money);
    }

    private void buyLottos() {
        money = Money.of(inputView.inputMoney());

        manualLottoNum = inputView.inputManualLottoNum();
        money.buyLotto(manualLottoNum);

        autoLottoNum = money.divide(Lotto.PRICE);
        money.buyLotto(autoLottoNum);
    }

    private List<Lotto> generateLottos(int manualLottoNum, int autoLottoNum) {
        List<Lotto> manualLottos = Stream.generate(inputView::inputManualLottoNumbers)
            .map(lottoService::generateManual)
            .limit(manualLottoNum)
            .collect(Collectors.toList());

        List<Lotto> autoLottos = Stream.generate(lottoService::generateAuto)
            .limit(autoLottoNum)
            .collect(Collectors.toList());

        return Stream.concat(manualLottos.stream(), autoLottos.stream())
            .collect(Collectors.toList());
    }
}
