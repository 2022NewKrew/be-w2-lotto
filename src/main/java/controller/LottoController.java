package controller;

import domain.Lottos;
import domain.Rank;
import domain.WinningNumbers;
import java.io.IOException;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final static int LOTTO_PURCHASE_PRICE = 1000;

    public static void startLotto() throws IOException {

        int money = InputView.inputMoney();
        int countOfPurchaseLotto = calculateCountOfPurchaseLotto(money);
        int moneyOfPurchaseLotto = calculateMoneyOfPurchaseLotto(money);

        final Lottos lottos = Lottos.purchaseLottos(countOfPurchaseLotto);

        OutputView.outputLottos(lottos);

        final WinningNumbers winningNumbers = InputView.inputWinningNumbers();
        final Map<Integer, Integer> winningStatistics = winningNumbers.winningConfirmation(lottos);
        final float profitRate = calculateProfitRate(winningStatistics,moneyOfPurchaseLotto);
        OutputView.outputWinning(winningStatistics,profitRate);
    }

    private static int calculateCountOfPurchaseLotto(int money) {
        return money / LOTTO_PURCHASE_PRICE;
    }

    private static int calculateMoneyOfPurchaseLotto(int money) {
        return money - money % LOTTO_PURCHASE_PRICE;
    }

    private static float calculateProfitRate(Map<Integer, Integer> winningStatistics, int money) {
        float totalProfitMoney = calculateProfitMoney(winningStatistics);
        return (totalProfitMoney - money) / money * 100;
    }

    // Q. OutputView의 outputWinning과 로직이 많이 겹치는데 합치는게 좋을까요?
    private static float calculateProfitMoney(Map<Integer, Integer> winningStatistics) {
        float totalProfitMoney = 0.0f;
        final Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            int countOfMatch = rank.getCountOfMatch();
            int winningMoney = rank.getWinningMoney();
            int countOfWinningRank = winningStatistics.getOrDefault(countOfMatch, 0);
            totalProfitMoney += (winningMoney * countOfWinningRank);
        }
        return totalProfitMoney;
    }
}
