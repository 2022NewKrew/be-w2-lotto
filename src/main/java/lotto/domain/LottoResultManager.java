package lotto.domain;

import lotto.VO.Rank;


public class LottoResultManager {
    private final LottoResult lottoResult;

    public LottoResultManager() {
        this.lottoResult = new LottoResult();
    }

    public void addResult(int numMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(numMatch, matchBonus);

        if (rank != null) {
            this.lottoResult.increaseCountOfRank(rank);
        }
    }

    public int getTotalReturn() {
        int totalReward = 0;
        for (Rank rank : Rank.values()) {
            totalReward += this.lottoResult.getCountOf(rank) * rank.getWinningMoney();
        }
        return totalReward;
    }

    public LottoResult getLottoResult(){
        return this.lottoResult;
    }

}
