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
        final Money money = inputMoney();

        final Lottos lottos = purchaseLotto(money.countOfPurchaseLotto());

        final WinningNumbers winningNumbers = inputWinningNumbers();

        final Map<Rank, Integer> winningStatistics = lottos.winningConfirm(winningNumbers);
        final float profitRate = money.calculateProfitRate(winningStatistics);
        OutputView.outputWinning(winningStatistics, profitRate);
    }

    private static Money inputMoney() throws IOException {
        return new Money(InputView.inputMoney());
    }

    private static Lottos purchaseLotto(int countOfPurchaseLotto) throws IOException {
        final int countOfManual = InputView.inputCountOfManual();
        final int countOfAuto = countOfPurchaseLotto - countOfManual;
        final List<List<Integer>> manualLottos = InputView.inputManualLottos(countOfManual);
        Lottos lottos = Lottos.purchaseLottos(countOfPurchaseLotto, manualLottos);
        OutputView.outputLottos(lottos, countOfAuto, countOfManual);
        return lottos;
    }

    private static WinningNumbers inputWinningNumbers() throws IOException {
        final List<Integer> inputWinningNumbers = InputView.inputWinningNumbers();
        final int BonusNumber = InputView.inputBonusNumber();
        return WinningNumbers.createWinningNumbers(
            inputWinningNumbers, BonusNumber);
    }
}
