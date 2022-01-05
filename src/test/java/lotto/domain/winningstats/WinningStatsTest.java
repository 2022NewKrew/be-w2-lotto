package lotto.domain.winningstats;

import lotto.domain.winningstats.lottobundle.LottoBundle;
import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningStatsTest {

    @Test
    void printWinningStats() {

        int lottoPurchaseMoney = 4500;
        LottoBundle lottoBundle = new LottoBundle(lottoPurchaseMoney);
        List<Integer> lastWeekLottoNumberList = List.of(1,2,3,4,5,6);
        int bonusBall = 7;

        WinningStats winningStats = new WinningStats(lottoBundle, lastWeekLottoNumberList,lottoPurchaseMoney,bonusBall);

        winningStats.printWinningStats();
    }
}