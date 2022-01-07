package lotto;

import lotto.domain.LotteryGameManager;

public class LotteryMain {

    public static void main(String[] args) {
        LotteryGameManager gameManager = new LotteryGameManager();
        gameManager.run();
    }
}
