package controller;

import domain.*;
import property.LottoProperties;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoController {
    public static void run() {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        long lotteryBoughtPrice = inputView.getLotteryBoughtPrice();

        long lotteryBoughtCount = lotteryBoughtPrice / LottoProperties.LOTTERY_UNIT_PRICE;
        long manualBoughtCount = inputView.getManualBoughtCount(lotteryBoughtCount);
        long autoBoughtCount = lotteryBoughtCount - manualBoughtCount;

        List<Set<Integer>> manualBoughtNumberSets = inputView.getManualBoughtLotteriesNumbers(manualBoughtCount);

        List<Lottery> manualBoughtLotteries = LotteryFactory.buildLotteries(manualBoughtNumberSets);
        List<Lottery> autoBoughtLotteries = LotteryFactory.buildLotteries(autoBoughtCount);
        outputView.printBoughtLotteries(manualBoughtLotteries, autoBoughtLotteries);

        List<Lottery> lotteries = new ArrayList<>();
        lotteries.addAll(manualBoughtLotteries);
        lotteries.addAll(autoBoughtLotteries);

        Set<Integer> winningLotteryNumberSet = inputView.getWinningLotteryNumbers();
        int winningLotteryBonusNumber = inputView.getBonusNumber();
        WinningLottery winningLottery = new WinningLottery(winningLotteryNumberSet, winningLotteryBonusNumber);

        Result result = Result.of(lotteryBoughtPrice, lotteries, winningLottery);
        outputView.printResult(result);
    }
}
