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

        System.out.println("총 수익율은 " + getEarningRatio(prizes, money) + "%입니다.");
    }

    private static void printResultPerPrize(List<Prize> prizes, Prize prize){
        int prizeCount = (int) prizes.stream().filter(prize_ -> prize_ == prize).count();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prize.getCorrectAmount()).append("개 일치");

        if(prize == Prize.SECOND_BONUS)
            stringBuilder.append(", 보너 볼 일치");

        stringBuilder.append(" (").append(prize.getMoney()).append("원)- ").append(prizeCount).append("개");
        System.out.println(stringBuilder);
    }

    private static int getEarningRatio(List<Prize> prizes, int money){
        int moneySpent = (int)(money / Lotto.cost) * Lotto.cost;
        if (moneySpent == 0)
            return 0;

        int moneyEarn = prizes.stream()
                            .filter(Objects::nonNull)
                            .map(Prize::getMoney)
                            .reduce(0, Integer::sum);

        return (int)(((double)moneyEarn / moneySpent) * 100 - 100);
    }
}
