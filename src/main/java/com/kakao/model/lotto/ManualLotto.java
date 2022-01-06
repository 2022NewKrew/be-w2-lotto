package com.kakao.model.lotto;

import com.kakao.exception.PickedNumberException;
import com.kakao.model.LottoNumbers;


public class ManualLotto extends Lotto {
    public ManualLotto(LottoNumbers pickedNumbersOfLotto) {
        super(pickedNumbersOfLotto);
    }
}
