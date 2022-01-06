package com.meg.w2lotto.domain.result;

import com.meg.w2lotto.domain.lotto.LastWinningLotto;
import com.meg.w2lotto.domain.lotto.Lotto;
import com.meg.w2lotto.domain.lotto.LottoNumber;

public class Result {

    private LastWinningLotto winningLotto;
    private Lotto myLotto;
    private Prize prize;

    public Result(LastWinningLotto winningLotto, Lotto myLotto) {
        this.winningLotto = winningLotto;
        this.myLotto = myLotto;
        calculateCorrectCounts();
    }

    private void calculateCorrectCounts() {
        prize = Prize.valueOf(getCorrectCountsOfLotto(), containBonusBall());
    }


    private int getCorrectCountsOfLotto() {
        int cnt = 0;
        for (LottoNumber num : winningLotto.getNumbers()) {
            if (myLotto.contains(num)) cnt += 1;
        }
        return cnt;
    }

    private boolean containBonusBall() {
        return myLotto.contains(winningLotto.getBonusBall());
    }

    public Prize getPrize() {
        return prize;
    }
}
