package com.david.lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumber;

    public Lotto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int calculateCountOfMatch(List<Integer> winningNumber) {
        return (int) lottoNumber.stream().filter(winningNumber::contains).count();
    }

    public boolean checkBonusNumber(int bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
