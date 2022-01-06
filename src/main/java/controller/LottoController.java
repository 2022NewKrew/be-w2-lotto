package controller;

import domain.Lottos;
import domain.Money;
import domain.Rank;
import domain.WinningNumbers;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LottoController {

    public static void startLotto() throws IOException {
        Money money = InputView.inputMoney();
        final Lottos lottos = Lottos.purchaseLottos(money.countOfPurchaseLotto());

        OutputView.outputLottos(lottos);

        final WinningNumbers winningNumbers = inputWinningNumbers();

        final Map<Rank, Integer> winningStatistics = lottos.winningConfirm(winningNumbers);
        final float profitRate = calculateProfitRate(winningStatistics,
            money.moneyOfPurchaseLotto());
        OutputView.outputWinning(winningStatistics, profitRate);
    }

    private static WinningNumbers inputWinningNumbers() throws IOException {
        final List<Integer> inputWinningNumbers = InputView.inputWinningNumbers();
        final int BonusNumber = InputView.inputBonusNumber();
        return WinningNumbers.createWinningNumbers(
            inputWinningNumbers, BonusNumber);
    }

    private static float calculateProfitRate(Map<Rank, Integer> winningStatistics, int money) {
        float totalProfitMoney = calculateProfitMoney(winningStatistics);
        return (totalProfitMoney - money) / money * 100;
    }

    private static float calculateProfitMoney(Map<Rank, Integer> winningStatistics) {
        float totalProfitMoney = 0.0f;
        final Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            int countOfWinningRank = winningStatistics.getOrDefault(rank, 0);
            totalProfitMoney += rank.calculateProfitMoney(countOfWinningRank);
        }
        return totalProfitMoney;
    }
}
