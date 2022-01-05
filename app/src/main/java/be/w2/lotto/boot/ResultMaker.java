package be.w2.lotto.boot;

import be.w2.lotto.cashier.Cashier;
import be.w2.lotto.lottos.LastWinningLotto;
import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.result.Report;
import be.w2.lotto.result.Result;
import be.w2.lotto.result.ResultCalculator;
import be.w2.lotto.view.input.Input;
import be.w2.lotto.view.output.Output;

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

    private LastWinningLotto lastWinningLotto;

    public void proceedBy(List<Lotto> purchaseLotto) {
        inputLastWinningLotto();

        Result result = getResult(purchaseLotto);
        outputResult(result);

        int investment = getInvestment(purchaseLotto);
        Report report = createReportBy(result, investment);
        outputReport(report);
    }

    private void inputLastWinningLotto() {
        this.lastWinningLotto = Input.inputLastWinningLotto();
    }

    private Result getResult(List<Lotto> purchaseLotto) {
        return ResultCalculator.getResultOfGame(purchaseLotto, lastWinningLotto);
    }

    private int getInvestment(List<Lotto> purchaseLotto) {
        return purchaseLotto.size() * Cashier.PRICE_PER_LOTTO;
    }

    private void outputResult(Result result) {
        Output.outputResult(result);
    }

    private void outputReport(Report report) {
        Output.outputReport(report);
    }

    private Report createReportBy(Result result, int investment) {
        return new Report(investment, result.getRevenue());
    }
}
