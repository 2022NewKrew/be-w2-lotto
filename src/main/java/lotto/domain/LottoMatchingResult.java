package lotto.domain;

import java.util.Map;

import static lotto.domain.LottoShop.PRICE;

public class LottoMatchingResult {
    private final Map<Prize, Long> occurrencesByPrize;

    public LottoMatchingResult(Map<Prize, Long> occurrencesByPrize) {
        this.occurrencesByPrize = occurrencesByPrize;
    }

    public float getEarningsRate() {
        long purchaseCosts = PRICE * occurrencesByPrize.values().stream()
                .reduce(0L, Long::sum);
        long prizeMoneySum = occurrencesByPrize.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getMoney() * entry.getValue())
                .sum();
        return ((float) (prizeMoneySum - purchaseCosts) / purchaseCosts) * 100;
    }

    public Long getOccurrences(Prize prize) {
        return occurrencesByPrize.getOrDefault(prize, 0L);
    }
}
