package controller;

import domain.Lottery;
import domain.LotteryGame;
import domain.Rank;
import domain.WinningLottery;

import java.util.List;
import java.util.Map;

public class LotteryGameController {

    private final LotteryGame lotteryGame;

    public LotteryGameController(int totalPrice) {
        lotteryGame = new LotteryGame(totalPrice);
    }

    public void setManualLottery(int numberOfManual){
        lotteryGame.setManualLottery(numberOfManual);
    }

    public void startLotteryGame(List<List<Integer>> manualLotteries) {
        lotteryGame.startLotteryGame(manualLotteries);
    }

    public LotteryGame getLotteryGame() {
        return lotteryGame;
    }

    public Map<Rank, Integer> getResult(List<Integer> winningNumbers, int bonusNumber) {
        WinningLottery winningLottery = new WinningLottery(new Lottery(winningNumbers), bonusNumber);
        return lotteryGame.compareLotteries(winningLottery);
    }

    public long getProfit(Map<Rank, Integer> results) {
        return lotteryGame.getProfit(results);
    }
}
