package controller;

import static utility.Parser.*;

import java.util.List;

import domain.Lotteries;
import domain.Lottery;
import domain.Result;
import domain.WinningLottery;
import view.InputView;
import view.OutputView;

public class LotteryGameController {
    public void run() {
        Lotteries lotteries = initLotteries();

        List<Lottery> autoLotteries = lotteries.getAutoLotteries();
        List<Lottery> manualLotteries = lotteries.getManualLotteries();
        OutputView.outputLotteries(autoLotteries, manualLotteries);

        Result result = compareLotteries(lotteries);

        int totalLotteriesPrice = getTotalPrice(lotteries);
        long profit = result.getProfit(totalLotteriesPrice);
        OutputView.outputResults(result, profit);
    }

    private Lotteries initLotteries(){
        int totalLotteriesPrice = InputView.inputTotalPrice();
        int manualLotteriesAmount = InputView.inputManualAmount();
        List<String> inputNumbers = InputView.inputManualNumbers(manualLotteriesAmount);
        List<List<Integer>> manualNumbers = parseNumbers(inputNumbers);

        return new Lotteries(totalLotteriesPrice, manualLotteriesAmount, manualNumbers);
    }

    private Result compareLotteries(Lotteries lotteries) {
        String inputNumber = InputView.inputWinningNumbers();
        List<Integer> winningNumbers = parseIntegerFromLine(inputNumber);
        int bonusNumber = InputView.inputBonusNumber();

        WinningLottery winningLottery = new WinningLottery(new Lottery(winningNumbers), bonusNumber);

        return lotteries.compareLotteries(winningLottery);
    }

    private int getTotalPrice(Lotteries lotteries) {
        return (lotteries.getAutoLotteries().size() + lotteries.getManualLotteries().size()) * lotteries.getPrice();
    }
}

