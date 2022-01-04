package lotto.view;

import lotto.domain.lottobundle.LottoBundle;
import lotto.domain.WinningStats;

public class ConsoleOutputView {

    public static void printLottoCount(int count) {
        System.out.println(Integer.toString(count)+"개를 구매했습니다.");
    }
    public static void printLottoBundle(LottoBundle lottoBundle){
        System.out.println(lottoBundle);
    }

    public static void printWinningStats(WinningStats winningStats){
        System.out.println(winningStats.printWinningStats());
    }
}
