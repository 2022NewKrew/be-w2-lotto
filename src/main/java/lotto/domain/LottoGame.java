package lotto.domain;

import lotto.view.LottoPrinter;

import java.util.*;

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
            winningAmount += rank.getWinningMoney() * countOfMatched;
        }
    }

    public void createLottoResult(LottoBundle lottoBundle, WinningLotto winningLotto) {
        for (Lotto lotto : lottoBundle.getLottos()) {
            Rank rank = winningLotto.matchLotto(lotto);
            appendStatistics(rank);
        }
    }

    public void printStatistics(LottoBundle lottoBundle) {
        LottoPrinter.printLottoStatisticsTitle();
        calculateWinningAmount();
        LottoPrinter.printLottoYield(winningAmount, lottoBundle.getLottoCount() * Constants.LOTTO_PRICE);
    }

    private void appendStatistics(Rank rank) {
        if (rank != null) {
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }

    public LottoResult createResult(LottoBundle lottoBundle, WinningLotto winningLotto) {
        createLottoResult(lottoBundle, winningLotto);
        calculateWinningAmount();
        int purchaseAmount = lottoBundle.getLottoCount() * Constants.LOTTO_PRICE;
        float totalRateOfReturn = 100 * (winningAmount - purchaseAmount) / purchaseAmount;

        return createStatistics(totalRateOfReturn);
    }

    private LottoResult createStatistics(float totalRateOfReturn) {
        List<String> message = new ArrayList<>();
        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        for (Rank rank : ranks) {
            message.add(String.format(Constants.PRINT_MATCHED_FORMAT,
                    rank.getMatchString(), rank.getWinningMoney(), statistics.getOrDefault(rank, 0)));
        }
        return new LottoResult(message, totalRateOfReturn);
    }
}
