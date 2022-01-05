package lotto.domain;

import lotto.exception.InvalidInputException;

public class ValidInput {
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
}
