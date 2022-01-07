package view;

import java.util.List;

public class OutputView {
    public static void printLabel(String label) {
        System.out.println(label);
    }

    public static void printPurchasedLottoListString(List<String> lottoStringList) {
        for (String lottoString : lottoStringList) {
            System.out.println(lottoString);
        }
    }
    /*
    public void printAllLotto(List<PurchasedLotto> allLotto, int manualPurchasedAmount) {
        System.out.println();
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", manualPurchasedAmount, allLotto.size()-manualPurchasedAmount);
        for (PurchasedLotto lotto : allLotto) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printWinningStats(List<String> winningStatsStrings) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (String winningStatsString : winningStatsStrings) {
            System.out.println(winningStatsString);
        }
    }

    public void printWinningRate(double winningRate) {
        System.out.printf("총 수익률은 %.2f%%입니다.\n", winningRate);
    }

     */
}
