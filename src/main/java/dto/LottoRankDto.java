package dto;

import model.lotto.LottoRank;

public class LottoRankDto {
    private final int matchNumber;
    private final int reward;
    private final boolean needBonusNumber;
    private final int rank;

    public LottoRankDto(LottoRank lottoRank) {
        this.matchNumber = lottoRank.getMatchNumber();
        this.reward = lottoRank.getReward();
        this.needBonusNumber = lottoRank.getNeedBonusNumber();
        this.rank = lottoRank.getRank();
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getReward() {
        return reward;
    }

    public boolean getNeedBonusNumber() {
        return needBonusNumber;
    }

    public int getRank() {
        return rank;
    }
}
