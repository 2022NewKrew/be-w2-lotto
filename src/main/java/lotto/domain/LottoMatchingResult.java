package lotto.domain;

import java.util.Map;

import static lotto.Main.PRICE;

/**
 * 로또 매칭 결과({@link Prize}별 맞은 횟수)를 갖고 있는 클래스
 */
public class LottoMatchingResult {

    private final Map<Prize, Long> occurrencesByPrize;

    public LottoMatchingResult(Map<Prize, Long> occurrencesByPrize) {
        this.occurrencesByPrize = occurrencesByPrize;
    }

    /**
     * @return 로또 수익률(%)
     */
    public float calculateEarningsRate() {
        long purchaseCosts = PRICE * occurrencesByPrize.values().stream()
            .reduce(0L, Long::sum);
        long prizeMoneySum = occurrencesByPrize.entrySet().stream()
            .mapToLong(entry -> entry.getKey().getMoney() * entry.getValue())
            .sum();
        return ((float) (prizeMoneySum - purchaseCosts) / purchaseCosts) * 100;
    }

    /**
     * @param prize 몇번 나왔는지 확인할 {@link Prize}
     * @return {@code prize}가 나온 횟수
     */
    public Long calculateOccurrences(Prize prize) {
        return occurrencesByPrize.getOrDefault(prize, 0L);
    }
}
