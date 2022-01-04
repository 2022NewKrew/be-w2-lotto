package lotto.dto;

import java.util.Collections;
import java.util.Map;
import lotto.domain.LottoRank;

public class LottoResultDTO {

    private final Map<LottoRank, Long> lottoRankCount;
    private final double profitRate;

    public LottoResultDTO(Map<LottoRank, Long> lottoRankCount, double profitRate) {
        this.lottoRankCount = lottoRankCount;
        this.profitRate = profitRate;
    }

    public Map<LottoRank, Long> getLottoRankCount() {
        return Collections.unmodifiableMap(lottoRankCount);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
