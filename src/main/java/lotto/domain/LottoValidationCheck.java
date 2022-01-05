package lotto.domain;

import java.util.List;

import static lotto.domain.LottoSetting.*;

public class LottoValidationCheck {
    static Integer userMakeCountValidation(Integer payment, Integer userMakeCount){
        return (Math.min(payment / LOTTO_PRICE, (Math.max(0, userMakeCount))   )); //유효한 유저생성 로또번호 개수로 수정
    }

    public static void stringLottoValidationCheck(List<String> stringLottoList){
        if(stringLottoList.size() != LOTTO_LENGTH){
            throw new IllegalArgumentException("로또 번호 개수가 올바르지 않습니다.");
        }

        for(int i = 1 ; i < stringLottoList.size() ; i++){
            if(stringLottoList.get(i-1).equals(stringLottoList.get(i))){
                throw new IllegalArgumentException("중복된 번호가 존재합니다.");
            }
        }

        for(int i = 0 ; i <stringLottoList.size() ; i++){
            if(!isValidInteger(stringLottoList.get(i))){
                throw new IllegalArgumentException("유효하지 않은 로또 값이 입력됌.");
            }
            if(Integer.valueOf(stringLottoList.get(i)) < LOTTO_NUMBER_RANGE_START || LOTTO_NUMBER_RANGE_LAST < Integer.valueOf(stringLottoList.get(i))){
                throw new IllegalArgumentException("유효하지 않은 로또 값이 입력됌.");
            }
        }
    }

    private static boolean isValidInteger(String strInteger){
        for(int i = 0 ; i < strInteger.length() ; i++){
            if(strInteger.charAt(i) < '0' || strInteger.charAt(i) > '9'){
                return false;
            }
        }
        return (strInteger.length() > 0);
    }
}
