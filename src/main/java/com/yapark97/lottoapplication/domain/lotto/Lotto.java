package com.yapark97.lottoapplication.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
