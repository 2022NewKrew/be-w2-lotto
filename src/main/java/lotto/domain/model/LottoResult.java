package lotto.domain.model;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LottoResult {
    private static final int MIN_MATCH_NUMBER = 3;

    private double totalRateOfReturn;
    private Map<Long, Integer> matchCounts;

    private LottoResult(double totalRateOfReturn, Map<Long, Integer> matchCounts) {
        this.totalRateOfReturn = totalRateOfReturn;
        this.matchCounts = new HashMap<>(matchCounts);
    }

    public static LottoResult of(int purchasePrice, WinningLotto winningLotto, Lottos lottos) {
        Map<Long, Integer> matchCounts = new HashMap<>();

        for (Rank rank : Rank.values()) {
            matchCounts.put(rank.getWinningMoney(), 0);
        }

        initMatchCount(winningLotto, lottos, matchCounts);

        final double totalRateOfReturn = calculateTotalProfit(purchasePrice, matchCounts);

        return new LottoResult(totalRateOfReturn, matchCounts);
    }

    private static void initMatchCount(WinningLotto winningLotto, Lottos lottos, Map<Long, Integer> matchCounts) {
        List<Lotto> allLotto = lottos.getLottos();

        for (Lotto lotto : allLotto) {
            final List<Integer> lottoNumbers = lotto.getLottoNumbers();
            final int matchCount = winningLotto.getMatchNumberCount(lottoNumbers);
            final boolean containBonusBall = winningLotto.isContainBonusBall(lottoNumbers);

            updateMatchCount(containBonusBall, matchCount, matchCounts);
        }
    }

    private static void updateMatchCount(boolean containBonusBall, int matchCount, Map<Long, Integer> matchCounts) {
        if (matchCount < MIN_MATCH_NUMBER) {
            return;
        }

        final Rank rank = Rank.valueOf(containBonusBall, matchCount);
        matchCounts.merge(rank.getWinningMoney(), 1, (existCount, initCount) -> existCount + initCount);
    }

    public int getMatchCount(Rank rank) {
        return Optional.ofNullable(matchCounts.get(rank.getWinningMoney())).orElse(0);
    }

    private static double calculateTotalProfit(int purchasePrice, Map<Long, Integer> matchCounts) {
        long totalProfit = matchCounts.entrySet().stream()
                .mapToLong(index -> index.getKey() * index.getValue())
                .sum();

        long totalPrice = totalProfit - purchasePrice;
        return (totalPrice / (double)purchasePrice) * 100.0;
    }

    public double getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
