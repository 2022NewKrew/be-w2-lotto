package dto;

import model.lotto.LottoRank;

public class LottoRankDto {
    private final LottoRank lottoRank;

    public LottoRankDto(LottoRank lottoRank) {
        this.lottoRank = lottoRank;
    }

    public int getMatchNumber() {
        return lottoRank.getMatchNumber();
    }

    public int getReward() {
        return lottoRank.getReward();
    }

}
