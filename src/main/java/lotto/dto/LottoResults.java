package lotto.dto;

import lotto.utils.Rank;
import lotto.utils.RankMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
