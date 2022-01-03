package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.PurchaseInfo;
import lotto.domain.WinningInfo;

import java.util.List;

public class CLIOutputManager implements OutputManager {
    private static final String PRIZE_TITLE = "당첨 통계\n---------";
    public void printAllLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printPrizes(PurchaseInfo purchaseInfo, WinningInfo winningInfo) {
        System.out.println(PRIZE_TITLE);
        for (int i = 0; i < WinningInfo.MATCH_COUNT.size(); i++) {
            System.out.printf("%d개 일치(%d원)- %d개%n", WinningInfo.MATCH_COUNT.get(i), WinningInfo.PRIZE.get(i), winningInfo.getWin().get(i));
        }
        double returnRate = (double)winningInfo.getReturnAmount() / purchaseInfo.getPurchaseAmount();
        System.out.printf("총 수익률은 %.2f%%입니다.%n", returnRate * 100);
    }
}
