package domain;

import java.util.HashMap;
import java.util.Map;

public class WinningStats {
    private final Map<Integer, Integer> prizeMap = new HashMap<>();
    private final int winningPrize;
    public WinningStats(int winningPrize){
        this.winningPrize = winningPrize;
    }
    public void addStats(int matchCount, int num){
        prizeMap.put(matchCount,num);
    }
}
