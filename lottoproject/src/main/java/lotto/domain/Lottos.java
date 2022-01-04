package lotto.domain;

import lotto.util.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public Map<Rank,Integer> findResultMap(List<Integer> resultNumbers, int bonusNumber){
        Map<Rank,Integer> resultMap = new HashMap<>();
        for(Lotto lotto : lottos){
            Rank lottoRank = lotto.findRank(resultNumbers, bonusNumber);
            resultMap.put(lottoRank, resultMap.getOrDefault(lottoRank, 0)+1);
        }
        return resultMap;
    }

    public int findSize(){
        return lottos.size();
    }
}
