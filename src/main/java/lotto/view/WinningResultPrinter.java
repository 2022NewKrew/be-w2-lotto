package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.WinningResult;

public class WinningResultPrinter {
    public void printWinningResultPrinter(WinningResult winningResult) {
        System.out.println("\n당첨 통계\n---------");
        for (LottoResult result : LottoResult.values()) {
            StringBuilder resultStr = new StringBuilder();
            System.out.println(resultStr.append(result.getNumMatchingDigit()).append("개 일치")
                    .append(result.equals(LottoResult.BONUS) ? ", 보너스 볼 일치" : " ")
                    .append("(").append(result.getReward()).append("원) - ")
                    .append(winningResult.getCountOf(result)).append("개"));
        }
    }

    public void printWinningYield(double yield) {
        System.out.printf("총 수익률은 %.2f%%입니다.\n", yield);
    }
}
