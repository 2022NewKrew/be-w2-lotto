package lotto.util;

import java.util.List;

import static lotto.util.ConstantValue.*;

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

    public static void wrongLottoNumber(List<Integer> lottoNumbers){
        if(lottoNumbers.get(FIRST_IDX) < LOTTO_START_NUMBER || lottoNumbers.get(LAST_IDX) > LOTTO_LAST_NUMBER){
            throw new InvalidInputException("로또 숫자 범위에 맞지 않는 입력이 있습니다.");
        }
    }

    public static void wrongSize(String[] numInputString){
        if(numInputString.length != SIZE_OF_LOTTO){
            throw new InvalidInputException(
                    String.format("(현재: %d개, 기준: %d개) 번호 입력 갯수가 잘못되었습니다.",numInputString.length, SIZE_OF_LOTTO)
            );
        }
    }

    public static void wrongSize(List<Integer> numList){
        if(numList.size() != SIZE_OF_LOTTO){
            throw new InvalidInputException(
                    String.format("(현재: %d개, 기준: %d개) 중복 번호 입력, 번호 갯수가 잘못되었습니다.",numList.size(), SIZE_OF_LOTTO)
            );
        }
    }
}
