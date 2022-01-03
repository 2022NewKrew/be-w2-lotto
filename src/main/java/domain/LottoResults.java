package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResults {

    private final Map<LottoResult, Integer> lottoResults = new HashMap<>();

    public LottoResults() {
    }

    public void addLottoResult(LottoResult lottoResult) {
        if (!lottoResults.containsKey(lottoResult)) {
            lottoResults.put(lottoResult, 1);
            return;
        }

        lottoResults.put(lottoResult, lottoResults.get(lottoResult) + 1);
    }

    public long getCountBy(LottoResult lottoResult) {
        if (!lottoResults.containsKey(lottoResult)) {
            return 0;
        }

        return lottoResults.get(lottoResult);
    }
}
