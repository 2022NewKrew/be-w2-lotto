package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.User;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;

public class GameManager {
    public static void start() {
        // TODO - 함수 정리
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<Lotto> lottoList = LottoMachine.buySeveralLotto(purchaseAmount);
        User user = new User(lottoList, purchaseAmount);
        ResultView.printLottoList(lottoList);

        List<Integer> lastWeekWinningNumbers = InputView.inputLastWeekWinningNumber();
        Map<Integer, Integer> lottoResult = user.calculateLottoResult(lastWeekWinningNumbers);
        double rateOfReturn = user.calculateRateOfReturn(lastWeekWinningNumbers);
        ResultView.printLottoResult(lottoResult);
        ResultView.printRateOfReturn(rateOfReturn);
    }
}
