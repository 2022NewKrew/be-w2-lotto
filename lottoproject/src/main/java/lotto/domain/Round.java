package lotto.domain;

import lotto.util.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Round {
    private final Lottos lottos;
    private final Map<Rank,Integer> resultMap;

    public Round(List<Lotto> lottos, List<Integer> resultNumbers, int bonusNumber){
        this.lottos = new Lottos(lottos);
        this.resultMap = findResultMap(resultNumbers, bonusNumber);
    }

    private Map<Rank,Integer> findResultMap(List<Integer> resultNumbers, int bonusNumber){
        return lottos.findResultMap(resultNumbers, bonusNumber);
    }

    public Map<Rank,Integer> findResultMap(){
        return resultMap;
    }

    public int findLottoCount(){
        return lottos.findSize();
    }

    public int findTotalReward(){
        int totalReward = 0;
        for (Map.Entry<Rank, Integer> rank : resultMap.entrySet()) {
            totalReward += rank.getKey().getWinningMoney() * rank.getValue();
        }
        return totalReward;
    }
}