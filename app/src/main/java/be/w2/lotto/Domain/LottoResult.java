package be.w2.lotto.Domain;

import java.util.*;

public class LottoResult {

    private Map<HitCount, Integer> result;

    public LottoResult() {
        result = new EnumMap<>(HitCount.class);
        for (HitCount hitCount : HitCount.values())
            result.put(hitCount, 0);
    }

    public void add(HitCount key) {
        if (key != null)
            result.replace(key, result.get(key) + 1);
    }

    public int calculateBenefit() {
        int benefit = 0;
        for (HitCount hitCount : HitCount.values())
            benefit += (result.get(hitCount) * hitCount.getPrice());
        return benefit;
    }

    public List<List<String>> getStatistics() {
        List<List<String>> res = new ArrayList<>();
        for (HitCount hitCount : HitCount.values()) {
            res.add(getStatisticsRow(hitCount));
        }
        return res;
    }

    private List<String> getStatisticsRow(HitCount hitCount) {
        List<String> statistics = new ArrayList<>();
        statistics.add(hitCount.getMessage());
        statistics.add(String.valueOf(result.get(hitCount)));
        return statistics;
    }

}
