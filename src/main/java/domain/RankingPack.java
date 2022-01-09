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

    private long calculateRanking(Ranking targetRank) {
        return rankingList.stream().filter(ranking -> ranking == targetRank).count();
    }

    private long calculatePrize() {
        return rankingList.stream().map(Ranking::getWiningPrize).reduce(Long::sum).orElse(0L);

    }

}
