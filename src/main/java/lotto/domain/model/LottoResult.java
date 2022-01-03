package lotto.domain.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static Map<Integer, Prize> intToPrizeMapping = new HashMap<>();

    private List<Integer> winningNumbers;
    Map<Prize, Integer> winningResult;

    static {
        for (Prize prize : Prize.values()) {
            intToPrizeMapping.put(prize.getNumberOfMatches(), prize);
        }
    }

    public LottoResult(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        winningResult = new HashMap<>();
        Arrays.stream(Prize.values()).forEach(prize -> winningResult.put(prize, 0));
    }

    public void countNumberOfMatches(Lotto lotto) {
        int matched = lotto.getNumbers().stream().reduce(0, (count, number) -> {
            return count + (winningNumbers.contains(number) ? 1 : 0);
        });
        Prize prize = intToPrizeMapping.get(matched);
        if (prize != null) {
            winningResult.put(prize, winningResult.get(prize) + 1);
        }
    }

    public Integer getCount(Prize prize) {
        return winningResult.get(prize);
    }

}
