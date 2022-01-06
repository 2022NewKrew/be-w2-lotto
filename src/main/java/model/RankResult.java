package model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RankResult {
    private final Map<LottoRanks, Integer> rankResults;

    public RankResult() {
        rankResults = new EnumMap<>(LottoRanks.class);
    }

    public void calculateRankResults(WinningNumber winningNumber, Lottos lottos) {
        for (LottoRanks rank : LottoRanks.values()) {
            rankResults.put(rank, 0);
        }

        List<LottoRanks> lottoRanks = lottos.compareLottos(winningNumber);
        for(LottoRanks lottoRank: lottoRanks){
            rankResults.put(lottoRank, rankResults.get(lottoRank) + 1);
        }
    }

    public int getCountByRank(LottoRanks lottoRank){
        return rankResults.get(lottoRank);
    }
}
