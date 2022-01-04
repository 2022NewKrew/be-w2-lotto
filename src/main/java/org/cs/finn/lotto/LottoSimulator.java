package org.cs.finn.lotto;

import org.cs.finn.lotto.domain.LottoWinnings;
import org.cs.finn.lotto.domain.Lottos;
import org.cs.finn.lotto.domain.LottoResult;
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
        if (lottoSimulatorView.checkNotEnoughMoney(money)) {
            return;
        }

        final Lottos lottos = new Lottos();
        lottoSimulatorView.buyLottos(sRand, lottos, money);

        final LottoWinnings lottoWinnings = userInput.requestLottoWinnings();
        final LottoResult lottoResult = new LottoResult(lottoWinnings, lottos);
        lottoSimulatorView.printResult(lottoResult, money);
    }

}
