package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LottoResult {
    private static final int MIN_MATCH_NUMBER = 3;

    private double totalRateOfReturn;
    private Map<Long, Integer> matchCounts;

    public LottoResult(int purchasePrice, WinningLotto winningLotto, PurchaseLotto purchaseLotto) {
        this.matchCounts = new HashMap<>();

        initMatchCount(winningLotto, purchaseLotto);
        this.totalRateOfReturn = calculateTotalProfit(purchasePrice);
    }

    private void initMatchCount(WinningLotto winningLotto, PurchaseLotto purchaseLottos) {
        List<Lotto> lottos = purchaseLottos.getLottos();

        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.getMatchNumberCount(lotto.getLottoNumbers());
            updateMatchCount(matchCount);
        }
    }

    private void updateMatchCount(int matchCount) {
        if (matchCount < MIN_MATCH_NUMBER) {
            return;
        }

        final int index = matchCount - MIN_MATCH_NUMBER;
        final Rank[] ranks = Rank.values();

        matchCounts.put(ranks[index].getWinningMoney(), getMatchCount(ranks[index]) + 1);
    }

    public int getMatchCount(Rank rank) {
        return Optional.ofNullable(matchCounts.get(rank.getWinningMoney())).orElse(0);
    }

    private double calculateTotalProfit(int purchasePrice) {
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
