package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.WinningResult;

public class WinningResultPrinter {
    public void printWinningResultPrinter(WinningResult winningResult) {
        System.out.println("\n당첨 통계\n---------");
        for (LottoResult result : LottoResult.values()) {
            System.out.println(result.getNumMatchingDigit() + "개 일 (" + result.getReward() + "원) - " + winningResult.getCountOf(result) + "개");
        }
    }

    public void printWinningYield(double yield) {
        System.out.printf("총 수익률은 %.2f%%입니다.\n", yield);
    }
}
