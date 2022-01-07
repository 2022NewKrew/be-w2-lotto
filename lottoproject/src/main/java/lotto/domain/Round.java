package lotto.domain;

import lotto.exception.InvalidListSizeException;
import lotto.exception.InvalidValueRangeException;
import lotto.util.Rank;
import lotto.util.Util;

import java.util.List;
import java.util.Map;

public class Round {
    private final Lottos lottos;
    private final Result result;

    public Round(Lottos lottos, String winningNumbersString, String bonusNumberString){
        this.lottos = lottos;
        List<Integer> winningNumbers = checkWinningNumbers(Util.convStringToIntegerArraylist(winningNumbersString, ","));
        this.result = new Result(findResultMap(winningNumbers, Integer.parseInt(bonusNumberString)), lottos.findSize());
    }

    private Map<Rank,Integer> findResultMap(List<Integer> winningNumbers, int bonusNumber){
        return lottos.findResultMap(winningNumbers, bonusNumber);
    }

    private List<Integer> checkWinningNumbers(List<Integer> numbers){
        if(numbers.size()!= Util.LOTTO_NUMBER_COUNT){
            throw new InvalidListSizeException("당첨 번호 개수가 잘못되었습니다.");
        }
        for(Integer number : numbers){
            checkWinningNumberRange(number);
        }
        return numbers;
    }

    private int checkWinningNumberRange(int number){
        if(number< Util.LOTTO_MIN_NUMBER||number>Util.LOTTO_MAX_NUMBER){
            throw new InvalidValueRangeException("당첨 번호 숫자가 정상범위를 벗어났습니다.");
        }
        return number;
    }

    public Result getResult(){
        return result;
    }
}