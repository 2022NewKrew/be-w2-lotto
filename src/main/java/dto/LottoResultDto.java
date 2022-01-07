package dto;

import model.lotto.LottoRank;

import java.util.Collections;
import java.util.Map;

public class LottoResultDto {
    private final Map<LottoRank, Integer> result;

    public LottoResultDto(Map<LottoRank, Integer> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public int get(int rank) {
        return result.get(LottoRank.findLottoRankByRank(rank));
    }

    public boolean contains(int rank) {
        return result.containsKey(LottoRank.findLottoRankByRank(rank));
    }
}
