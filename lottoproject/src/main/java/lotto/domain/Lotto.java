package lotto.domain;

import lotto.exception.InvaildListSizeException;
import lotto.exception.InvaildValueRangeException;
import lotto.util.Rank;
import lotto.util.Util;
import org.apache.commons.lang3.BooleanUtils;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = checkLottoNumbers(numbers);
    }

    public Rank findRank(List<Integer> resultNumbers, int bonusNumber){
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

    private List<Integer> checkLottoNumbers(List<Integer> numbers) throws InvaildListSizeException, InvaildValueRangeException {
        if(numbers.size()!= Util.LOTTO_NUMBER_COUNT){
            throw new InvaildListSizeException("로또의 숫자 개수가 잘못되었습니다.");
        }
        for(Integer number : numbers){
            checkLottoNumberRange(number);
        }
        return numbers;
    }

    private int checkLottoNumberRange(int number) throws InvaildValueRangeException{
        if(number<Util.LOTTO_MIN_NUMBER||number>Util.LOTTO_MAX_NUMBER){
            throw new InvaildValueRangeException("로또 숫자가 정상범위를 벗어났습니다.");
        }
        return number;
    }
}
