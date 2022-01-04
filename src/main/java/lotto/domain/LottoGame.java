package lotto.domain;

import lotto.view.LottoPrinter;
import lotto.view.LottoScanner;

import java.util.*;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 5:06
 */
public class LottoGame {
    private final LottoBundle lottoBundle;
    private final List<Integer> lastWeekWinningNumbers;
    private final Map<Rank, Integer> statistics;
    private long winningAmount;

    public LottoGame(LottoBundle lottoBundle) {
        this.lottoBundle = lottoBundle;
        lastWeekWinningNumbers = LottoScanner.getLastWeekWinningNumbers();
        statistics = new HashMap<>();
        winningAmount = 0;
    }

    private void calculateWinningAmount() {
        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        for (Rank rank : ranks) {
            Integer countOfMatched = statistics.getOrDefault(rank, 0);
            LottoPrinter.printLottoRankResult(rank, countOfMatched);
            winningAmount += (long) rank.getWinningMoney() * countOfMatched;
        }
    }

    public void printStatistics(Integer purchaseAmount) {
        calculateWinningAmount();
        LottoPrinter.printLottoStatisticsTitle();
        LottoPrinter.printLottoYield(winningAmount, purchaseAmount);
    }

    public void playLottoGame() {
        for(Lotto lotto : lottoBundle.getLottos()) {
            playLotto(lotto);
        }
    }

    private void playLotto(Lotto lotto) {
        Integer winningNumberCount = lotto.matchLottoWithLastWeek(lastWeekWinningNumbers);
        boolean matchBonus = lotto.matchBonusBall(lottoBundle.getBonusBall());
        Rank rank = Rank.valueOf(winningNumberCount, matchBonus);
        if (rank != null) {
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }
}
