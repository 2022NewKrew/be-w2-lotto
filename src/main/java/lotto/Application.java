package lotto;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        long inputMoney = InputView.inputMoney();
        LottoController lottoController = LottoController.from(inputMoney);
        OutputView.printPurchaseLottoCount(lottoController.purchase());
        OutputView.printLottos(lottoController.getLottos());

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        LottoResult lottoResult = lottoController.result(winningNumbers, bonusNumber);
        OutputView.printLottoResult(lottoResult);

        BigDecimal profit = lottoController.profit(lottoResult.totalReward());
        OutputView.printProfit(profit);
    }
}
