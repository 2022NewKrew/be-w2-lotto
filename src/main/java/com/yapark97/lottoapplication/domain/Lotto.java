package com.yapark97.lottoapplication.domain;

import java.util.List;

public class Lotto {
    // 일급 컬렉션
    List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
