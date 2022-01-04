package view;

import domain.Lottery;
import domain.Rank;
import domain.Result;

import java.util.Arrays;
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
        System.out.println("당첨 통계\n---------");
        Arrays.stream(Rank.values()).filter((rank) -> rank != Rank.MISS)
                .forEach((rank) -> System.out.printf("%s- %d개\n",rank.getDescription(), result.getCountOf(rank)));
        System.out.printf("총 수익률은 %.2f%%입니다.\n", result.getYieldPercent());
    }
}
