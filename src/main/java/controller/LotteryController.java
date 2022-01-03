package controller;

import domain.LotteryGame;
import domain.Result;

import java.util.List;
import java.util.Map;

public class LotteryController {

    private LotteryGame lotteryGame;

    public LotteryController(int totalPrice) {
        this.lotteryGame = new LotteryGame(totalPrice);
    }

    public Map<Integer, Result> getResult(List<Integer> winningNumbers) {
        return lotteryGame.compareLotteries(winningNumbers);
    }

    public LotteryGame getLotteryGame() {
        return lotteryGame;
    }

    public long getProfit() {
        return lotteryGame.getProfit();
    }
}
