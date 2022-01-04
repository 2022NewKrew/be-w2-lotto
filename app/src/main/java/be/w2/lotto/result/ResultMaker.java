package be.w2.lotto.result;

import be.w2.lotto.cashier.Cashier;
import be.w2.lotto.lottos.LastWinningLotto;
import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.messages.GameMessage;
import be.w2.lotto.view.View;

import java.util.List;

/**
 * Singleton
 */
public class ResultMaker {

    private static ResultMaker INSTANCE;

    private ResultMaker() {
    }

    public static ResultMaker getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ResultMaker();
        return INSTANCE;
    }

    private View view = View.getInstance();
    private LastWinningLotto lastWinningLotto;

    public void produceResults(List<Lotto> purchaseLotto) {
        inputLastWinningLotto();
        Result result = ResultCalculator.getResultOfGame(purchaseLotto, lastWinningLotto);
        int investment = purchaseLotto.size() * Cashier.PRICE_PER_LOTTO;
        makeWinningStat(result, investment);
    }

    private void inputLastWinningLotto() {
        String lastWinningNumbers = view.inputStringWithMessage(GameMessage.INPUT_LAST_WINNING_NUMBER);
        this.lastWinningLotto = LastWinningLotto.of(lastWinningNumbers);
    }

    private void makeWinningStat(Result result, int investment) {
        WinningStatMaker winningStatMaker = new WinningStatMaker(result, investment);
        view.output(winningStatMaker.getStringOfWinningStat());
    }
}
