package lotto.view;

import lotto.domain.winningstats.lottobundle.LottoBundle;
import lotto.domain.winningstats.WinningStats;

public class ConsoleOutputView {

    public static void printLottoCount(long autoLottoCount,long manualLottoCount) {
        System.out.print("수동으로 " + manualLottoCount + "개를 구매했습니다.");
        System.out.println("자동으로 " + autoLottoCount + "개를 구매했습니다.");
    }

    public static void printLottoBundle(LottoBundle lottoBundle) {
        System.out.print(lottoBundle.printAutoLottoList());
    }

    public static void printWinningStats(WinningStats winningStats) {
        System.out.println(winningStats.printWinningStats());
    }

    public static void printError(Exception e){
        System.out.println(e.getMessage());
    }
    public static void printReInputMessage(){
        System.out.println("다시 입력해주세요.");
    }
}
