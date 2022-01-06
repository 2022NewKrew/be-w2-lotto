package lotto.dto;

import lotto.domain.result.LottoResult;

public class LottoCheckResponseDto {

    private final String lottoRankString;
    private final int earningRate;

    public LottoCheckResponseDto(LottoResult lottoResult) {
        this.lottoRankString = lottoResult.rankCounterToString();
        this.earningRate = lottoResult.getEarningRate();
    }

    public String getLottoRankString() {
        return lottoRankString;
    }

    public int getEarningRate() {
        return earningRate;
    }
}
