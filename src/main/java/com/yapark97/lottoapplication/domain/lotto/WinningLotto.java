package com.yapark97.lottoapplication.domain.lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusBall;

    public WinningLotto(List<Integer> numbers, int bonusBall) {
        super(numbers);
        this.bonusBall = bonusBall;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}