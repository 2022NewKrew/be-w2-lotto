package org.cs.finn.lotto;

import org.cs.finn.lotto.domain.LottoResult;
import org.cs.finn.lotto.domain.LottoWinnings;
import org.cs.finn.lotto.domain.Lottos;
import org.cs.finn.lotto.domain.Money;
import org.cs.finn.lotto.view.LottoSimulatorView;
import org.cs.finn.lotto.view.UserInput;

import java.security.SecureRandom;

public class LottoSimulator {
    private final SecureRandom sRand = new SecureRandom();
    private final UserInput userInput = new UserInput();
    private final LottoSimulatorView lottoSimulatorView = new LottoSimulatorView();

    public void run() {
        final Money money = userInput.requestMoney();
        if (money.notEnoughToBuyOneLotto()) {
            lottoSimulatorView.printNotEnoughMoney(money);
            return;
        }

        final Lottos lottos = new Lottos();
        final int countOfManuals = userInput.requestCountOfLottoManual(lottos, money);
        final Money left = userInput.requestBuyLottoManual(lottos, money, countOfManuals);

        lottos.addAll(left.buyLottoAutoAll(sRand));
        lottoSimulatorView.printLottos(lottos, countOfManuals, left.maxNumberToBuyLottos());

        final LottoWinnings lottoWinnings = userInput.requestLottoWinnings();
        final LottoResult lottoResult = new LottoResult(lottoWinnings, lottos);
        lottoSimulatorView.printResult(lottoResult, money);
    }
}
