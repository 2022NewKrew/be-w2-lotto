package lotto.domain;

import lotto.util.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Round {
    private final List<Lotto> lottos;
    private final List<Integer> resultNumbers;
    private final int bonusNumber;
    private final Map<Rank,Integer> resultMap;

    public Round(List<Lotto> lottos, List<Integer> resultNumbers, int bonusNumber){
        this.lottos = lottos;
        this.resultNumbers = resultNumbers;
        this.bonusNumber = bonusNumber;
        this.resultMap = findResultMap(lottos, resultNumbers, bonusNumber);
    }

    private Map<Rank,Integer> findResultMap(List<Lotto> lottos, List<Integer> resultNumbers, int bonusNumber){
        Map<Rank,Integer> resultMap = new HashMap<>();
        for(Lotto lotto : lottos){
            Rank lottoRank = lotto.findRank(resultNumbers, bonusNumber);
            resultMap.put(lottoRank, resultMap.getOrDefault(lottoRank, 0)+1);
        }
        return resultMap;
    }

    public Map<Rank,Integer> findResultMap(){
        return resultMap;
    }

    public int findLottoCount(){
        return lottos.size();
    }

    public int findTotalReward(){
        int totalReward = 0;
        for (Map.Entry<Rank, Integer> rank : resultMap.entrySet()) {
            totalReward += rank.getKey().getWinningMoney() * rank.getValue();
        }
        return totalReward;
    }
}