package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.List;

public class ValidInput {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int FIRST_IDX = 0;
    private static final int LAST_IDX = 5;

    public static void inputUnderValue(int standardValue, int inputValue){
        if(standardValue > inputValue){
            throw new InvalidInputException(
                    String.format("(입력: %d , 최소 :%d) 기준보다 낮아 적절하지 않은 입력입니다.", inputValue, standardValue)
            );
        }
    }

    public static void wrongRangeValue(int startValue, int endValue , int inputValue){
        if( inputValue < startValue || endValue < inputValue){
            throw new InvalidInputException("범위에 맞지 않는 입력입니다.");
        }
    }

    public static void wrongLottoNumber(List<Integer> lottoNumbers){
        if(lottoNumbers.get(FIRST_IDX) < LOTTO_START_NUMBER || lottoNumbers.get(LAST_IDX) > LOTTO_LAST_NUMBER){
            throw new InvalidInputException("로또 숫자 범위에 맞지 않는 입력이 있습니다.");
        }
    }
}
