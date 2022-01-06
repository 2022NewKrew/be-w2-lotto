package com.kakao.model.lotto;

import com.kakao.exception.PickedNumberException;

import java.util.List;

public class ManualLotto extends Lotto {
    ManualLotto(List<Integer> pickedNumbersOfLotto) throws PickedNumberException {
        super(pickedNumbersOfLotto);
    }
}
