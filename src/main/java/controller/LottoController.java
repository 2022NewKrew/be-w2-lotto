package controller;

import domain.*;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Set;

public class LottoController {

    public static void run() {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        long lotteryBoughtPrice = inputView.getLotteryBoughtPrice();
        List<Lottery> lotteries = LotteryFactory.buildLotteries(lotteryBoughtPrice);
        outputView.printBoughtLotteries(lotteries);

        Set<Integer> winningLotteryNumberSet = inputView.getLotteryNumberSet();
        int winningLotteryBonusNumber = inputView.getBonusNumber();
        WinningLottery winningLottery = new WinningLottery(winningLotteryNumberSet, winningLotteryBonusNumber);
        Result result = Result.of(lotteryBoughtPrice, lotteries, winningLottery);

        outputView.printResult(result);
    }
}
