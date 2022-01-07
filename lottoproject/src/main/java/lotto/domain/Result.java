package lotto.domain;

import lotto.util.Rank;
import lotto.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank,Integer> resultMap;
    private final int totalReward;
    private final float totalRateOfReturn;
    private final List<String> messages;

    public Result(Map<Rank,Integer> resultMap, int lottoCount){
        this.resultMap = resultMap;
        this.totalReward = findTotalReward(resultMap);
        this.totalRateOfReturn = findTotalRateOfReturn(totalReward, lottoCount);
        this.messages = generateMessages(resultMap);
    };

    private int findTotalReward(Map<Rank,Integer> resultMap){
        int totalReward = 0;
        for (Map.Entry<Rank, Integer> rank : resultMap.entrySet()) {
            totalReward += rank.getKey().getWinningMoney() * rank.getValue();
        }
        return totalReward;
    }

    private float findTotalRateOfReturn(int totalReward, int lottoCount){
        return (float)totalReward*100/(lottoCount* Util.LOTTO_PRICE);
    }

    private List<String> generateMessages(Map<Rank,Integer> resultMap){
        List<String> messages = new ArrayList<String>();
        for (Rank rank : Rank.values()) {
            if(rank == Rank.NONE) continue;
            messages.add(rank.toString()+" - "+resultMap.getOrDefault(rank, 0)+"개");
        }
        return messages;
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }

    public float getTotalRateOfReturn() {
        return totalRateOfReturn;
    }

    public List<String> getMessages() {
        return messages;
    }
}
