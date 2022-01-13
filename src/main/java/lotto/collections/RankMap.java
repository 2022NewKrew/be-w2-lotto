package lotto.collections;

import lotto.utils.Rank;

import java.util.*;

public final class RankMap {
    private final Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);

    public RankMap(){
        for(Rank rank: Rank.values()){
            rankMap.put(rank, 0);
        }
    }
    public Set<Rank> getKeySet() {
        return rankMap.keySet();
    }

    public int getValue(Rank rank) {
        return rankMap.get(rank);
    }

    public void addCnt(Rank rank){
        if (rank ==null){
            return;
        }
        int value = rankMap.get(rank) +1;
        rankMap.put(rank, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RankMap)) return false;
        RankMap rankMap1 = (RankMap) o;
        return rankMap.equals(rankMap1.rankMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankMap);
    }

    @Override
    public String toString() {
        return "RankMap{" +
                "rankMap=" + rankMap +
                '}';
    }
}
