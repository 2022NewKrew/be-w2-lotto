package lottogame.controller;

import lottogame.domain.*;
import lottogame.view.LottoGameView;

public class LottoGameController {
    private LottoGameView view = new LottoGameView();
    private PurchaseAmount purchaseAmount;
    private LotteryTickets lotteryTickets;
    private Statistics statistics;
    private int rateOfReturn;


    public LottoGameController() {
    }

    public void run() {
        purchaseLotteryTickets();
        printLotteryTickets();
        inputLastWeekWinningNumbers();
        printWinningStatistic();
    }

    private void purchaseLotteryTickets() {
        purchaseAmount = new PurchaseAmount(view.inputPurchaseAmount());
        lotteryTickets = purchaseAmount.buyLotteryTickets(new RandomGenerator());
    }

    public void printLotteryTickets() {
        view.printLotteryTickets(lotteryTickets);
    }

    public void inputLastWeekWinningNumbers() {
        LotteryNumbers winningNumbers = new ManualGenerator(view.inputWinningNumbers()).generate();
        LotteryNumber bonusNumber = new LotteryNumber(view.inputBonusBall());
        statistics = lotteryTickets.makeStatistics(winningNumbers, bonusNumber);
        rateOfReturn = purchaseAmount.calculateRateOfReturn(statistics.sumPrizeMoney());
    }

    public void printWinningStatistic() {
        view.printWinningStatistic(statistics, rateOfReturn);
    }
}
