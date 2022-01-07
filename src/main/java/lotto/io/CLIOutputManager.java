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

    @Override
    public String printPurchaseInfo(PurchaseInfo purchaseInfo, List<Lotto> lottoList) {
        StringBuilder result = new StringBuilder();
        int manualLottoCount = purchaseInfo.getManualLottoCount();
        int autoLottoCount = purchaseInfo.getNumOfPurchase() - manualLottoCount;
        result.append(String.format(PURCHASE_RESULT_FORMAT, manualLottoCount, autoLottoCount))
                .append(printAllLotto(lottoList));
        return result.toString();
    }

    @Override
    public String printPrizes(PurchaseInfo purchaseInfo, WinningInfo winningInfo) {
        StringBuilder result = new StringBuilder();
        result.append(PRIZE_TITLE);
        Arrays.stream(Rank.values()).filter(Rank::isWin).forEach(rank -> {
            String format = setFormat(rank);
            result.append(String.format(format, rank.getMatchCount(), rank.getWinningMoney(), winningInfo.getWinCount().get(rank)))
                    .append(LINE_BREAK);
        });
        double returnRate = (double) (winningInfo.getReturnAmount() - purchaseInfo.getPurchaseAmount()) / purchaseInfo.getPurchaseAmount();
        result.append(String.format(RETURN_RATE_FORMAT, returnRate * 100));
        return result.toString();
    }

    private String printAllLotto(List<Lotto> lottoList) {
        StringBuilder result = new StringBuilder();
        lottoList.stream().forEach(lotto -> {
            result.append(lotto.getNumbers())
                    .append(LINE_BREAK);
        });
        return result.toString();
    }

    private String setFormat(Rank rank) {
        if (rank == Rank.SECOND) {
            return MATCH_COUNT_BONUS_FORMAT;
        }
        return MATCH_COUNT_FORMAT;
    }
}
