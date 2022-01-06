package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.PurchaseInfo;
import lotto.domain.Rank;
import lotto.domain.WinningInfo;

import java.util.Arrays;
import java.util.List;

public class CLIOutputManager implements OutputManager {
    private static final String PURCHASE_RESULT_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";
    private static final String PRIZE_TITLE = "당첨 통계\n---------";
    private static final String MATCH_COUNT_FORMAT = "%d개 일치(%d원)- %d개%n";
    private static final String MATCH_COUNT_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개%n";
    private static final String RETURN_RATE_FORMAT = "총 수익률은 %.2f%%입니다.%n";

    public void printPurchaseInfo(PurchaseInfo purchaseInfo) {
        int manualLottoCount = purchaseInfo.getManualLottoCount();
        int autoLottoCount = purchaseInfo.getNumOfPurchase() - manualLottoCount;
        System.out.format(PURCHASE_RESULT_FORMAT, manualLottoCount, autoLottoCount);
    }

    public void printAllLotto(List<Lotto> lottoList) {
        lottoList.stream().forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public void printPrizes(PurchaseInfo purchaseInfo, WinningInfo winningInfo) {
        System.out.println(PRIZE_TITLE);
        Arrays.stream(Rank.values()).forEach(rank -> {
            String format = setFormat(rank);
            System.out.format(format, rank.getMatchCount(), rank.getWinningMoney(), winningInfo.getWinCount().get(rank));
        });
        double returnRate = (double) (winningInfo.getReturnAmount() - purchaseInfo.getPurchaseAmount()) / purchaseInfo.getPurchaseAmount();
        System.out.format(RETURN_RATE_FORMAT, returnRate * 100);
    }

    private String setFormat(Rank rank) {
        if (rank == Rank.SECOND) {
            return MATCH_COUNT_BONUS_FORMAT;
        }
        return MATCH_COUNT_FORMAT;
    }
}
