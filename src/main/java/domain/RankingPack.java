package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RankingPack {
    private final List<Ranking> rankingList;

    RankingPack(List<Ranking> rankingList){
        this.rankingList = rankingList;
    }
    public WinningStats makeWiningStats(){
        WinningStats winningStats = new WinningStats(calculatePrize());
        Arrays.stream(Ranking.values()).forEach(ranking -> winningStats.addStats(ranking,calculateRanking(ranking)));
        return winningStats;
    }

    private int calculateRanking(Ranking targetRank){
        return rankingList.stream().filter(ranking -> ranking.getMatchCount()!=0 && ranking==targetRank).collect(Collectors.toList()).size();
    }
    private int calculatePrize(){
        return rankingList.stream().map(ranking -> ranking.getWiningPrize()).reduce((prize, total) -> prize+total).get();
    }

}
