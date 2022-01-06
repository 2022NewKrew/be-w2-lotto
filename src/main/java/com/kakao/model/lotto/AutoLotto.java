package com.kakao.model.lotto;

import com.kakao.exception.PickedNumberException;
import java.util.List;

public class AutoLotto extends Lotto {
    public AutoLotto(List<Integer> pickedNumbersOfLotto) throws PickedNumberException {
        super(pickedNumbersOfLotto);
    }
}
