package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RankingPack {
    private final List<Ranking> rankingList;

    RankingPack(List<Ranking> rankingList){
        this.rankingList = rankingList;
    }
    void calculateRanking(Ranking targetRank){
        rankingList.stream().filter(ranking -> ranking==targetRank).collect(Collectors.toList()).size();
    }
    public int calculatePrize(){
        return rankingList.stream().map(ranking -> ranking.getWiningPrize()).reduce((prize, total) -> prize+total).get();
    }

}
