package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LottoResult {
    private static final int MIN_MATCH_NUM = 3;
    private static final int[] MATCH_COUNT_PRICE = {5000, 50000, 1500000, 2000000000};

    private long totalRateOfReturn;
    private Map<Integer, Integer> matchCounts;

    public LottoResult(int purchasePrice, Lotto lastWeekLotto, PurchaseLotto purchaseLotto) {
        this.matchCounts = new HashMap<>();

        initMatchCount(lastWeekLotto, purchaseLotto);
        this.totalRateOfReturn = calculateTotalProfit(purchasePrice);
    }

    private void initMatchCount(Lotto lastWeekLotto, PurchaseLotto purchaseLotto) {
        List<Lotto> lottos = purchaseLotto.getLottos();
        List<Integer> lastWeekLottoNumbers = lastWeekLotto.getLottoNumbers();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchNumberCount(lastWeekLottoNumbers);
            updateMatchCount(matchCount);
        }
    }

    private void updateMatchCount(int matchCount) {
        if (matchCount < MIN_MATCH_NUM) {
            return;
        }

        final int index = matchCount - MIN_MATCH_NUM;
        matchCounts.put(MATCH_COUNT_PRICE[index], getMatchCount(index) + 1);
    }

    public long calculateTotalProfit(int purchasePrice) {
        int totalProfit = matchCounts.entrySet().stream()
                .mapToInt(index -> index.getKey() * index.getValue())
                .sum();

        return (totalProfit * 100L) / purchasePrice;
    }

    public int getMatchCount(int index) {
        return Optional.ofNullable(matchCounts.get(MATCH_COUNT_PRICE[index])).orElse(0);
    }

    public long getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
