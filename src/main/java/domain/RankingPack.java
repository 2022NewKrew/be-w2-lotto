package domain;

import java.util.Arrays;
import java.util.List;

public class RankingPack {
    private final List<Ranking> rankingList;

    RankingPack(List<Ranking> rankingList) {
        this.rankingList = rankingList;
    }

    public WinningStats makeWiningStats() {
        WinningStats winningStats = new WinningStats(calculatePrize());
        Arrays.stream(Ranking.values()).forEach(ranking ->
                winningStats.addStats(ranking, calculateRanking(ranking))
        );
        return winningStats;
    }

    private int calculateRanking(Ranking targetRank) {
        return (int) rankingList.stream().filter(ranking -> ranking == targetRank).count();
    }

    private int calculatePrize() {
        return rankingList.stream().map(Ranking::getWiningPrize).reduce(Integer::sum).get();
    }

}
