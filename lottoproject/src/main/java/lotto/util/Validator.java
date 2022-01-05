package lotto.util;

import lotto.exception.InvaildValueRangeException;

public class Validator {
    public static int checkInputMoney(int inputMoney) throws InvaildValueRangeException{
        if(inputMoney<0){
            throw new InvaildValueRangeException("금액의 값이 음수입니다.");
        }
        return inputMoney;
    }
}
