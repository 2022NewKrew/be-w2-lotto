package view.Printer;

import domain.Lotto;
import domain.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ResultPrinter {
    public static void print(List<Prize> prizes, int money){
        System.out.println("당첨 통계\n---------");

        Arrays.stream(Prize.values())
                .forEach(prize -> printResultPerPrize(prizes, prize));

        System.out.println(getEarningRatio(prizes, money));
    }

    private static void printResultPerPrize(List<Prize> prizes, Prize prize){
        int prizeNum = (int) prizes.stream()
                                .filter(prize_ -> prize_ == prize)
                                .count();
        System.out.println(prize.getCorrectAmount() + "개 일치 (" + prize.getMoney() + "원)- " + prizeNum + "개");
    }

    private static double getEarningRatio(List<Prize> prizes, int money){
        int moneySpent = (int)(money / Lotto.cost) * Lotto.cost;
        if (moneySpent == 0)
            return 0;

        int moneyEarn = prizes.stream()
                            .filter(Objects::nonNull)
                            .map(Prize::getMoney)
                            .reduce(0, Integer::sum);

        return ((double)moneyEarn / moneySpent) * 100 - 100;
    }
}
