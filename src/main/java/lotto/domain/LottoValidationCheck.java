package lotto.domain;

import static lotto.domain.LottoSetting.LOTTO_PRICE;

public class LottoValidationCheck {
    static Integer userMakeCountValidation(Integer payment, Integer userMakeCount){
        return (Math.min(payment / LOTTO_PRICE, (Math.max(0, userMakeCount))   )); //유효한 유저생성 로또번호 개수로 수정
    }
}
