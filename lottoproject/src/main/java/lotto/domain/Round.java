package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Round {
    private final List<Lotto> lottos;
    private final List<Integer> resultNumbers;
    private final Map<Integer,Integer> resultMap;

    public Round(List<Lotto> lottos, List<Integer> resultNumbers){
        this.lottos = lottos;
        this.resultNumbers = resultNumbers;
        this.resultMap = findResultMap(lottos, resultNumbers);
    };

    private Map<Integer,Integer> findResultMap(List<Lotto> lottos, List<Integer> resultNumbers){
        Map<Integer,Integer> resultMap = new HashMap<Integer,Integer>();
        for(Lotto lotto : lottos){
            int matchNumberCount = lotto.findMatchNumberCount(resultNumbers);
            resultMap.put(matchNumberCount, resultMap.getOrDefault(matchNumberCount, 0)+1);
        }
        return resultMap;
    }

    public Map<Integer,Integer> findResultMap(){
        return resultMap;
    }
}