package domain;

import java.util.Map;

public class LottoResults {

    private final Map<LottoResult, Long> lottoResults;

    public LottoResults(Map<LottoResult, Long> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public long getCountBy(LottoResult lottoResult) {
        return lottoResults.getOrDefault(lottoResult, 0L);
    }

    public long getEarnedMoney() {
        return lottoResults.keySet().stream()
                .mapToLong(lottoResult -> getCountBy(lottoResult) * lottoResult.getPrizeMoney())
                .sum();
    }

}
