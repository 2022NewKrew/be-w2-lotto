package lotto.domain;

import lotto.util.Rank;
import org.apache.commons.lang3.BooleanUtils;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Rank findRank(List<Integer> resultNumbers, int bonusNumber){
        System.out.println(Rank.valueOf(findMatchNumberCount(resultNumbers), isMatchBonusNumber(bonusNumber)));
        return Rank.valueOf(findMatchNumberCount(resultNumbers), isMatchBonusNumber(bonusNumber));
    }

    private int findMatchNumberCount(List<Integer> resultNumbers){
        int matchNumberCount = 0;
        for(Integer number : numbers){
            matchNumberCount += BooleanUtils.toInteger(resultNumbers.contains(number));
        }
        return matchNumberCount;
    }

    private Boolean isMatchBonusNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }

    public String toString(){
        return numbers.toString();
    }
}
