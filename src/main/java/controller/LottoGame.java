package controller;

import domain.LastWeekLottoResult;
import domain.LottoMachine;
import domain.LottoStatistics;
import domain.LottoTickets;
import java.util.List;
import java.util.Set;
import view.InputView;
import view.ResultView;

public class LottoGame {

    private static long removeChange(long money) {
        final int LOTTO_PRICE = 1000;
        return money / LOTTO_PRICE * LOTTO_PRICE;
    }

    public static void start() {
        long purchaseAmount = removeChange(InputView.inputPurchaseAmount());
        List<Set<Integer>> manualNumbers = InputView.inputManualNumbers();
        LottoMachine lottoMachine = new LottoMachine();
        LottoTickets lottoTicketList = lottoMachine.buyLottoTickets(purchaseAmount, manualNumbers);
        ResultView.printLottoList(lottoTicketList);

        Set<Integer> lastWeekWinningNumbers = InputView.inputLastWeekWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        LastWeekLottoResult lottoResult = new LastWeekLottoResult(lastWeekWinningNumbers, bonusNumber);
        ResultView.printLottoResult(lottoResult.winningLottoCount(lottoTicketList));
        LottoStatistics lottoStatistics = new LottoStatistics(lottoResult.winningLottoCount(lottoTicketList));
        ResultView.printRateOfReturn(lottoStatistics.rateOfReturn(purchaseAmount));
    }
}
