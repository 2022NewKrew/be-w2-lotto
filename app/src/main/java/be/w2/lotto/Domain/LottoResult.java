package be.w2.lotto.Domain;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoResult {

    static private final int MAX_HIT_AMOUNT = 6;

    private Map<Integer, Integer> result;

    public LottoResult() {
        result = new TreeMap<>();
        for (int i = 0; i <= MAX_HIT_AMOUNT; i++)
            result.put(i, 0);
    }

    public void add(int key) {
        result.replace(key, result.get(key) + 1);
    }

    public int calculateBenefit() {
        int benefit = 0;
        for(HitCount hitCount : HitCount.values())
            benefit += (result.get(hitCount.getHitCount())*hitCount.getPrice());
        return benefit;
    }

    public List<List<Integer>> getStatistics(){
        List<List<Integer>> res = new ArrayList<>();
        for(HitCount hitCount : HitCount.values()){
            res.add(getStatisticsRow(hitCount));
        }
        return res;
    }

    List<Integer> getStatisticsRow(HitCount hitCount){
        List<Integer> statistics = new ArrayList<>();
        statistics.add(hitCount.getHitCount());
        statistics.add(hitCount.getPrice());
        statistics.add(result.get(hitCount.getHitCount()));
        return statistics;
    }

}
