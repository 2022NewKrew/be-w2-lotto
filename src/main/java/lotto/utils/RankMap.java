package lotto.utils;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RankMap {
    private static final Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);

    public RankMap(){
        for(Rank rank: Rank.values()){
            rankMap.put(rank, 0);
        }
    }
    public static Set<Rank> getKeySet() {
        return rankMap.keySet();
    }

    public static int getValue(Rank rank) {
        return rankMap.get(rank);
    }

    public static void addCnt(Rank rank){
        if (rank ==null){
            return;
        }
        int value = rankMap.get(rank) +1;
        rankMap.put(rank, value);
    }
}
