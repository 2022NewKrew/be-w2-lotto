package lotto.domain;

import org.apache.commons.lang3.BooleanUtils;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int findMatchNumberCount(List<Integer> resultNumbers){
        int matchNumberCount = 0;
        for(Integer number : numbers){
            matchNumberCount += BooleanUtils.toInteger(resultNumbers.contains(number));
        }
        return matchNumberCount;
    }

    public String toString(){
        return numbers.toString();
    }
}
