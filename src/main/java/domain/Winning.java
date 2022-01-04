package domain;

import view.Outputs;

import java.util.Arrays;
import java.util.List;

public class Winning {

    private final List<Integer> rewards = Arrays.asList(2000000000, 1500000, 50000, 5000, 0);
    private int totalEarningMoney = 0;
    private int totalSpentMoney = 0;

    public Winning() {}

    Outputs outputs = new Outputs();

    public void showWinningTickets(List<Integer> rankCountList) {
        for (int i = 3; i >= 0; i--) {  // 4등부터 1등까지
            outputs.printRewards(6 - i, rewards.get(i), rankCountList.get(i));

        }
    }

    public void getEarningRate(List<Integer> rankCountList) {
        Lotto lotto = new Lotto();
        for (int i = 0; i < rewards.size(); i++) {
            totalEarningMoney += rankCountList.get(i) * rewards.get(i);
            totalSpentMoney += rankCountList.get(i) * lotto.getLOTTO_PRICE();
        }
        float earningRate = (totalEarningMoney - totalSpentMoney) / totalSpentMoney * 100;
        outputs.printEarningRate(earningRate);
    }
}
