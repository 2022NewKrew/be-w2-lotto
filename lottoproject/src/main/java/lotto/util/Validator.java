package lotto.util;

import lotto.exception.InvaildListSizeException;
import lotto.exception.InvaildValueRangeException;
import java.util.List;

public class Validator {
    public static int checkInputMoney(int inputMoney) throws InvaildValueRangeException{
        if(inputMoney<1000){
            throw new InvaildValueRangeException("최소 구매 금액보다 입력 금액이 작습니다.");
        }
        return inputMoney;
    }

    public static void checkTotalCountWithManualCount(int totalCount, int manualCount) throws InvaildValueRangeException{
        if(manualCount<0){
            throw new InvaildValueRangeException("수동입력 로또 개수의 값이 음수입니다.");
        }
        if(manualCount>totalCount){
            throw new InvaildValueRangeException("로또 구매 가능 개수보다 수동입력 로또 개수가 더 큽니다.");
        }
    }

    public static List<Integer> checkLottoNumbers(List<Integer> numbers) throws InvaildListSizeException, InvaildValueRangeException{
        if(numbers.size()!=Util.LOTTO_NUMBER_COUNT){
            throw new InvaildListSizeException("로또의 숫자 개수가 잘못되었습니다.");
        }
        for(Integer number : numbers){
            checkLottoNumberRange(number);
        }
        return numbers;
    }

    private static int checkIntegerRange(int number, int start, int end, String message) throws InvaildValueRangeException{
        if(number<start||number>end){
            throw new InvaildValueRangeException(message);
        }
        return number;
    }

    public static int checkLottoNumberRange(int number) throws InvaildValueRangeException{
        return checkIntegerRange(number, Util.LOTTO_MIN_NUMBER, Util.LOTTO_MAX_NUMBER, "로또 숫자가 정상범위를 벗어났습니다.");
    }

}
