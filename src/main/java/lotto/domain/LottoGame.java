package lotto.domain;

import lotto.view.LottoPrinter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 5:06
 */
public class LottoGame {
    private final Map<Rank, Integer> statistics;
    private BigDecimal winningAmount;
    private BigDecimal totalRateOfReturn;

    public LottoGame() {
        statistics = new HashMap<>();
        winningAmount = BigDecimal.ZERO;
        totalRateOfReturn = BigDecimal.ZERO;
    }

    private void calculateWinningAmount() {
        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        for (Rank rank : ranks) {
            Integer countOfMatched = statistics.getOrDefault(rank, 0);
            LottoPrinter.printLottoRankResult(rank, countOfMatched);
            winningAmount = winningAmount.add(BigDecimal.valueOf(rank.getWinningMoney() * countOfMatched));
        }
    }

    public void createLottoResult(LottoBundle lottoBundle, WinningLotto winningLotto) {
        for (Lotto lotto : lottoBundle.getLottos()) {
            Rank rank = winningLotto.matchLotto(lotto);
            appendStatistics(rank);
        }
    }

    public void printStatistics() {
        LottoPrinter.printLottoStatisticsTitle();
        calculateWinningAmount();
        LottoPrinter.printLottoYield(totalRateOfReturn);
    }

    private void appendStatistics(Rank rank) {
        if (rank != null) {
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }

    public LottoResult createResult(LottoBundle lottoBundle, WinningLotto winningLotto) {
        createLottoResult(lottoBundle, winningLotto);
        calculateWinningAmount();
        BigDecimal purchaseAmount = BigDecimal.valueOf(lottoBundle.getLottoCount() * Constants.LOTTO_PRICE);
        totalRateOfReturn = winningAmount.subtract(purchaseAmount)
                .multiply(BigDecimal.valueOf(100)).divide(purchaseAmount, 2, RoundingMode.HALF_EVEN);

        return createStatistics();
    }

    private LottoResult createStatistics() {
        List<String> message = new ArrayList<>();
        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        for (Rank rank : ranks) {
            message.add(String.format(Constants.PRINT_MATCHED_FORMAT,
                    rank.getMatchString(), rank.getWinningMoney(), statistics.getOrDefault(rank, 0)));
        }
        return new LottoResult(message, totalRateOfReturn);
    }
}
