package lotto.domain;

import static lotto.domain.LottoSetting.LOTTO_PRICE;

public class LottoValidationCheck {
    static Integer userMakeCountValidation(Integer payment, Integer userMakeCount){
        return (Math.min(payment / LOTTO_PRICE, (Math.max(0, userMakeCount))   )); //유효한 input으로 수정
    }
}
