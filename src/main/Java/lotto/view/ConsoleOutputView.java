package lotto.view;

import lotto.domain.winningstats.lottobundle.LottoBundle;
import lotto.domain.winningstats.WinningStats;

public class ConsoleOutputView {

    public static void printLottoCount(long count) {
        System.out.println(Long.toString(count) + "개를 구매했습니다.");
    }

    public static void printLottoBundle(LottoBundle lottoBundle) {
        System.out.print(lottoBundle.printLottoBundle());
    }

    public static void printWinningStats(WinningStats winningStats) {
        System.out.println(winningStats.printWinningStats());
    }
}
