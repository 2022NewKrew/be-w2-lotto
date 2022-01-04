package view;

import domain.Lottery;
import domain.Rank;
import domain.Result;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printBoughtLotteries(List<Lottery> lotteryList) {
        System.out.printf("%d개를 구매하였습니다.\n", lotteryList.size());

        for (Lottery lottery : lotteryList) {
            System.out.println(lottery.getLotteryNumbers());
        }
    }

    @Override
    public void printResult(Result result) {
        for (Rank key : Rank.values()) {
            if (key == Rank.MISS) continue;

            System.out.printf("%s- %d개\n",key.getDescription(), result.getCountOf(key));
        }
        System.out.printf("총 수익률은 %d%%입니다.\n", result.getYieldPercent());
    }
}
