package lottogame.controller;

import lottogame.domain.*;
import lottogame.dto.Mapper;
import lottogame.dto.Statistics;
import lottogame.view.LottoGameView;

public class LottoGameController {
    private LottoGameView view;

    public LottoGameController(LottoGameView view) {
        this.view = view;
    }

    public void run() {
        Price defaultPrice = new Price(1000);
        Price purchasedPrice = new Price(view.inputPurchasedPrice());

        Amount totalAmount = new Amount(purchasedPrice, defaultPrice);
        Amount manualAmount = new Amount(view.inputManualPurchasedAmount());
        Amount autoAmount = totalAmount.subtract(manualAmount);

        LotteryTickets lotteryTickets = purchaseLotteryTickets(autoAmount, manualAmount);
        calculateWinningStatistics(lotteryTickets);
    }

    private LotteryTickets purchaseLotteryTickets(Amount autoAmount, Amount manualAmount) {
        LotteryTickets manualTickets = new LotteryTickets(view.inputManualPurchasedTickets(manualAmount), manualAmount.getAmount());
        LotteryTickets autoTickets = autoAmount.buyLotteryTickets(new RandomGenerator());
        view.printLotteryTickets(manualTickets, autoTickets);
        return manualTickets.combine(autoTickets);
    }

    public void calculateWinningStatistics(LotteryTickets lotteryTickets) {
        WinningTicket winningTicket = new WinningTicket(new LotteryTicket(view.inputWinningNumbers()), new LotteryNumber(view.inputBonusBall()));
        Ranks ranks = lotteryTickets.rankTickets(winningTicket);

        RateOfReturn rateOfReturn = RateOfReturn.calculate(ranks.sumPrizeMoney(), 14000);
        Statistics statistics = Mapper.makeStatistics(ranks);
        view.printWinningStatistic(statistics, rateOfReturn);
    }
}
