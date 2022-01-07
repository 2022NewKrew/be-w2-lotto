package com.meg.w2lotto.domain.lotto;

import java.util.List;

public class LastWinningLotto extends Lotto {

    private LottoNumber bonusBall;

    public LastWinningLotto(List<Integer> numbers, int bonusBall) {
        super(numbers);
        this.bonusBall = LottoNumber.valueOf(bonusBall);
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
