package lotto.domain;

import lotto.exception.InvaildListSizeException;
import lotto.exception.InvaildValueRangeException;
import lotto.util.Rank;
import lotto.util.Util;

import java.util.List;
import java.util.Map;

public class Round {
    private final Lottos lottos;
    private final Map<Rank,Integer> resultMap;

    public Round(List<Lotto> lottos, List<Integer> resultNumbers, int bonusNumber){
        this.lottos = new Lottos(lottos);
        this.resultMap = findResultMap(checkResultNumbers(resultNumbers), bonusNumber);
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

    private List<Integer> checkResultNumbers(List<Integer> numbers) throws InvaildListSizeException, InvaildValueRangeException {
        if(numbers.size()!= Util.LOTTO_NUMBER_COUNT){
            throw new InvaildListSizeException("당첨 번호 개수가 잘못되었습니다.");
        }
        for(Integer number : numbers){
            checkResultNumberRange(number);
        }
        return numbers;
    }

    private int checkResultNumberRange(int number) throws InvaildValueRangeException {
        if(number< Util.LOTTO_MIN_NUMBER||number>Util.LOTTO_MAX_NUMBER){
            throw new InvaildValueRangeException("당첨 번호 숫자가 정상범위를 벗어났습니다.");
        }
        return number;
    }
}