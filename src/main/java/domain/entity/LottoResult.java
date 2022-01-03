package domain.entity;

import java.util.Map;
import java.util.TreeMap;

public class LottoResult {
    private final Map<Integer, Integer> lottoResult;

    public LottoResult() {
        lottoResult = new TreeMap<>();

        lottoResult.put(3,5000);
        lottoResult.put(4,50000);
        lottoResult.put(5,1500000);
        lottoResult.put(6,2000000000);
    }

    public Map<Integer, Integer> getLottoResult() {
        return lottoResult;
    }
}
