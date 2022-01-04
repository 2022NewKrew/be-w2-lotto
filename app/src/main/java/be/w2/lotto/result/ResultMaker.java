package be.w2.lotto.result;

import be.w2.lotto.cashier.Cashier;
import be.w2.lotto.lottos.LastWinningLotto;
import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.messages.GameMessage;
import be.w2.lotto.view.Output;
import be.w2.lotto.view.View;

import java.util.List;

/**
 * Singleton
 */
public final class ResultMaker {

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

    public void proceedBy(List<Lotto> purchaseLotto) {
        inputLastWinningLotto();
        Result result = getResult(purchaseLotto);
        int investment = getInvestment(purchaseLotto);
        outputResult(result, investment);
    }

    private void inputLastWinningLotto() {
        String lastWinningNumbers = view.inputStringWithMessage(GameMessage.INPUT_LAST_WINNING_NUMBER);
        this.lastWinningLotto = LastWinningLotto.of(lastWinningNumbers);
    }

    private Result getResult(List<Lotto> purchaseLotto) {
        return ResultCalculator.getResultOfGame(purchaseLotto, lastWinningLotto);
    }

    private int getInvestment(List<Lotto> purchaseLotto) {
        return purchaseLotto.size() * Cashier.PRICE_PER_LOTTO;
    }

    private void outputResult(Result result, int investment) {
        view.output(Output.getOutputOfResult(result, investment));
    }
}
