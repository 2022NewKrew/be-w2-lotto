package lotto.domain.winningstats;

import lotto.domain.winningstats.lottobundle.LottoBundle;
import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;
import org.junit.jupiter.api.Test;

class WinningStatsTest {

    @Test
    void printWinningStats() {

        long lottoPurchaseMoney = 4000;
        int lottoPrice = 1000;
        String manualLottoNumbers = "1,2,3,4,5,6" + System.lineSeparator() + "2,3,4,5,6,7";
        LottoBundle lottoBundle = new LottoBundle(lottoPurchaseMoney, manualLottoNumbers, lottoPrice);
        Lotto lastWeekLottoNumberList = new Lotto("1,2,3,4,5,6");
        int bonusBall = 7;

        WinningStats winningStats = new WinningStats(lottoBundle, lastWeekLottoNumberList, bonusBall);

        winningStats.printWinningStats();
    }
}