package lotto.dto;

import lotto.collections.RankMap;

public class LottoResults {
    RankMap rankMap;
    int earnRate;

    public LottoResults(RankMap rankMap, int earnRate) {
        this.rankMap = rankMap;
        this.earnRate = earnRate;
    }

    public RankMap getRankMap() {
        return this.rankMap;
    }

    public int getEarnRate() {
        return this.earnRate;
    }
}
