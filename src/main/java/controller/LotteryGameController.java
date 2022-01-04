package controller;

import domain.LotteryGame;
import domain.Rank;

import java.util.List;
import java.util.Map;

public class LotteryGameController {

    private final LotteryGame lotteryGame;

    public LotteryGameController(int totalPrice) {
        this.lotteryGame = new LotteryGame(totalPrice);
    }

    public LotteryGame getLotteryGame() {
        return lotteryGame;
    }

    public Map<Rank, Integer> getResult(List<Integer> winningNumbers, int bonusNumber) {
        return lotteryGame.compareLotteries(winningNumbers, bonusNumber);
    }

    public long getProfit(Map<Rank, Integer> results) {
        return lotteryGame.getProfit(results);
    }
}
