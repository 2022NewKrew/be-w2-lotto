package lotto.domain;

import java.util.List;

import static lotto.domain.LottoSetting.LOTTO_LENGTH;
import static lotto.domain.LottoSetting.LOTTO_PRICE;

public class LottoValidationCheck {
    static Integer userMakeCountValidation(Integer payment, Integer userMakeCount){
        return (Math.min(payment / LOTTO_PRICE, (Math.max(0, userMakeCount))   )); //유효한 유저생성 로또번호 개수로 수정
    }

    public static void stringLottoValidationCheck(List<String> stringLottoList){
        if(stringLottoList.size() != LOTTO_LENGTH){
            throw new IllegalArgumentException("로또 번호 개수가 올바르지 않습니다.");
        }
    }
}
