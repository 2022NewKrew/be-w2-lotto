package lotto;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        long inputMoney = InputView.inputMoney();
        int selfLottoSize = InputView.inputSelfLottoSize();
        List<List<Integer>> selfLottoNumbers = InputView.inputSelfLottoNumbers(selfLottoSize);
        LottoController lottoController = LottoController.valueOf(inputMoney, selfLottoNumbers);
        OutputView.printPurchaseLottoCount(selfLottoSize,
            lottoController.purchase() - selfLottoSize);
        OutputView.printLottos(lottoController.getLottos());

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusBallNumber = InputView.inputBonusNumber();
        LottoResult lottoResult = lottoController.result(winningNumbers, bonusBallNumber);
        OutputView.printLottosResult(lottoResult);

        BigDecimal profit = lottoController.profit(lottoResult.totalReward());
        OutputView.printProfit(profit);
    }
}
