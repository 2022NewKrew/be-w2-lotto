package be.w2.lotto.Domain;

import java.util.*;

public class LottoResult {

    private Map<Prize, Integer> result;

    public LottoResult() {
        result = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values())
            result.put(prize, 0);
    }

    public void add(Prize key) {
        if (key != null)
            result.replace(key, result.get(key) + 1);
    }

    public int benefit() {
        int benefit = 0;
        for (Prize prize : Prize.values())
            benefit += (result.get(prize) * prize.getPrice());
        return benefit;
    }

    public List<List<String>> getStatistics() {
        List<List<String>> res = new ArrayList<>();
        for (Prize prize : Prize.values()) {
            res.add(getStatisticsRow(prize));
        }
        return res;
    }

    private List<String> getStatisticsRow(Prize prize) {
        List<String> statistics = new ArrayList<>();
        statistics.add(prize.getMessage());
        statistics.add(String.valueOf(result.get(prize)));
        return statistics;
    }

}
