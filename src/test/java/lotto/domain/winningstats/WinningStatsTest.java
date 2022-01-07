package lotto.domain.winningstats;

import lotto.domain.winningstats.lastweeknumberBundle.LastWeekLottoNumberList;
import lotto.domain.winningstats.lottobundle.LottoBundle;
import org.junit.jupiter.api.Test;

class WinningStatsTest {

    @Test
    void printWinningStats() {

        int lottoPurchaseMoney = 4500;
        LottoBundle lottoBundle = new LottoBundle(lottoPurchaseMoney);
        LastWeekLottoNumberList lastWeekLottoNumberList = new LastWeekLottoNumberList("1,2,3,4,5,6");
        int bonusBall = 7;

        WinningStats winningStats = new WinningStats(lottoBundle, lastWeekLottoNumberList,bonusBall);

        winningStats.printWinningStats();
    }
}