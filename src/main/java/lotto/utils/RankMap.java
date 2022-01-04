package lotto.utils;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RankMap {
    private final Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);

    public RankMap(){
        for(Rank rank: Rank.values()){
            rankMap.put(rank, 0);
        }
    }
    public Map<Rank,Integer> getRankMap(){
        return this.rankMap;
    }

    public Set<Rank> getKeySet() {
        return this.rankMap.keySet();
    }

    public int getValue(Rank rank) {
        return this.rankMap.get(rank);
    }

    public void addCnt(Rank rank){
        if (rank ==null){
            return;
        }
        int value = this.rankMap.get(rank) +1;
        this.rankMap.put(rank, value);
    }
}
