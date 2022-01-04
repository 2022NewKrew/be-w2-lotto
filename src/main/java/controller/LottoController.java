package controller;

import domain.Lottos;
import domain.Rank;
import domain.WinningNumbers;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final static String MONEY_RANGE_ERROR_MESSAGE = "구입금액은 0원 이상이어야 합니다.";

    private final static int LOTTO_PURCHASE_PRICE = 1000;

    // Q. 로직이 너무 긴 것같은데, 어떻게 줄이면 좋을까요?
    public static void startLotto() throws IOException {
        int money = InputView.inputMoney();
        validateMoney(money);
        int moneyOfPurchaseLotto = calculateMoneyOfPurchaseLotto(money);

        int countOfPurchaseLotto = calculateCountOfPurchaseLotto(money);
        final Lottos lottos = Lottos.purchaseLottos(countOfPurchaseLotto);

        OutputView.outputLottos(lottos);

        final WinningNumbers winningNumbers = inputWinningNumbers();

        final Map<Rank, Integer> winningStatistics = winningNumbers.winningConfirmation(lottos);
        final float profitRate = calculateProfitRate(winningStatistics, moneyOfPurchaseLotto);
        OutputView.outputWinning(winningStatistics, profitRate);
    }

    private static void validateMoney(int money) {
        if (money > 0) {
            throw new IllegalArgumentException(MONEY_RANGE_ERROR_MESSAGE);
        }
    }

    private static int calculateCountOfPurchaseLotto(int money) {
        return money / LOTTO_PURCHASE_PRICE;
    }

    private static int calculateMoneyOfPurchaseLotto(int money) {
        return money - money % LOTTO_PURCHASE_PRICE;
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

    // Q. OutputView의 outputWinning과 로직이 많이 겹치는데 합치는게 좋을까요?
    private static float calculateProfitMoney(Map<Rank, Integer> winningStatistics) {
        float totalProfitMoney = 0.0f;
        final Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            int winningMoney = rank.getWinningMoney();
            int countOfWinningRank = winningStatistics.getOrDefault(rank, 0);
            totalProfitMoney += (winningMoney * countOfWinningRank);
        }
        return totalProfitMoney;
    }
}
