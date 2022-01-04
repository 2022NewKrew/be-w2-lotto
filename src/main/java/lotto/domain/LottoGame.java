package lotto.domain;

import lotto.view.LottoPrinter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 5:06
 */
public class LottoGame {
    private final Map<Rank, Integer> statistics;
    private long winningAmount;

    public LottoGame() {
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

    public void createLottoResult(LottoBundle lottoBundle, WinningLotto winningLotto) {
        for (Lotto lotto : lottoBundle.getLottos()) {
            Rank rank = winningLotto.matchLotto(lotto);

            if (rank != null) {
                statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
            }
        }
    }

    public void printStatistics(LottoBundle lottoBundle) {
        LottoPrinter.printLottoStatisticsTitle();
        calculateWinningAmount();
        LottoPrinter.printLottoYield(winningAmount, lottoBundle.getLottoCount() * Constants.LOTTO_PRICE);
    }
}
