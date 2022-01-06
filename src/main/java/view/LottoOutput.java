package view;

import domain.LottoPack;
import domain.WinningStats;

public class LottoOutput {
    public static final String PRIZE_STR_FORMAT ="%d개 일치 (%d)- %d 개";
    public static void printLottoPack(LottoPack lottoPack){
        lottoPack.printLottoPack();
    }
    public static void printWinningStats(WinningStats winningStats){
        System.out.println("당첨 통계");
        System.out.println("-----------");
        winningStats.printMap();
        System.out.printf("총 수익률은 %.2f%%입니다.%n",winningStats.getTotalIncome());
    }
}
