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
    private final Map<Integer, Integer> statistics;

    public LottoGame(LottoBundle lottoBundle) {
        this.lottoBundle = lottoBundle;
        lastWeekWinningNumbers = LottoScanner.getLastWeekWinningNumbers();
        statistics = new HashMap<>();
    }

    public int calculateWinningAmount(Map<Integer, Integer> statistics) {
        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.FIRST);
        int winningAmount = 0;
        for (Rank rank : ranks) {
            int countOfMatch = rank.getCountOfMatch();
            int winningMoney = rank.getWinningMoney();
            Integer countOfMatched = statistics.getOrDefault(countOfMatch, 0);
            LottoPrinter.printLottoRankResult(countOfMatch, winningMoney, countOfMatched);
            winningAmount += winningMoney * countOfMatched;
        }
        return winningAmount;
    }

    public void calculateStatistics(Integer purchaseAmount) {
        LottoPrinter.printLottoStatisticsTitle();
        int winningAmount = calculateWinningAmount(statistics);
        LottoPrinter.printLottoYield(purchaseAmount, winningAmount);
    }

    public void playLottoGame() {
        for(Lotto lotto : lottoBundle.getLottos()) {
            playLotto(lotto);
        }
    }

    private void playLotto(Lotto lotto) {
        Integer winningNumberCount = lotto.matchLottoWithLastWeek(lastWeekWinningNumbers);
        if (winningNumberCount > 2) {
            statistics.put(winningNumberCount
                    , statistics.getOrDefault(winningNumberCount, 0) + 1);
        }
    }
}
