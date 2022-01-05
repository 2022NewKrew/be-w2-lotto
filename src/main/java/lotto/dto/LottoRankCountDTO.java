package lotto.dto;

import java.util.Map;
import lotto.domain.game.LottoRank;
import lotto.domain.game.LottoRankCount;

public class LottoRankCountDTO {

    private final Map<LottoRank, Long> lottoRankCount;

    public static LottoRankCountDTO from(LottoRankCount lottoRankCount) {
        return new LottoRankCountDTO(lottoRankCount.getLottoRankCount());
    }

    private LottoRankCountDTO(Map<LottoRank, Long> lottoRankCount) {
        this.lottoRankCount = lottoRankCount;
    }

    public long getCountByRank(LottoRank lottoRank) {
        return lottoRankCount.getOrDefault(lottoRank, 0L);
    }
}
