package view;

import domain.LottoPack;
import domain.WinningStats;

public class LottoOutput {
    public static final String PRIZE_STR_FORMAT = "%s (%d원)- %d 개";

    public static void printLottoPack(LottoPack lottoPack) {
        System.out.println(lottoPack.printLottoPack());
    }

    public static void printWinningStats(WinningStats winningStats, int buyPrice) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        winningStats.printMap();
        System.out.printf("총 수익률은 %.2f%%입니다.%n", winningStats.getTotalIncome(buyPrice));
    }
}
