package com.kakaocorp.lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;
    private final int bonusBall;

    public WinningLotto(List<Integer> numbers, int bonusBall) {
        this.numbers = numbers;
        this.bonusBall = bonusBall;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
