package lottogame.controller;

import lottogame.domain.lottery.LotteryTickets;
import lottogame.domain.lottery.LotteryTicketsFactory;
import lottogame.domain.statistics.Statistics;
import lottogame.domain.statistics.StatisticsFactory;
import lottogame.dto.PurchasedPrice;
import lottogame.dto.WinningNumbers;
import lottogame.view.LottoGameView;

public class LottoGameController {
    private LottoGameView view = new LottoGameView();
    private LotteryTickets lotteryTickets;
    private Statistics winningStatistics;

    public LottoGameController() {
    }

    public void run() {
        purchaseLotteryTickets();
        printLotteryTickets();
        inputLastWeekWinningNumbers();
        printWinningStatistic();
    }

    private void purchaseLotteryTickets() {
        PurchasedPrice purchasedPrice = view.inputPurchasedPrice();
        lotteryTickets = LotteryTicketsFactory.create(purchasedPrice);
    }

    public void printLotteryTickets() {
        view.printPurchasedTickets(lotteryTickets);
    }

    public void inputLastWeekWinningNumbers() {
        WinningNumbers winningNumbers = view.inputWinningNumbers();
        winningStatistics = StatisticsFactory.create(lotteryTickets, winningNumbers);
    }

    public void printWinningStatistic() {
        view.printWinningStatistic(winningStatistics);
    }
}
