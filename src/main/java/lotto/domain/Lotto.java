package lotto.domain;

import lotto.utils.RandomNumbers;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = RandomNumbers.getRandomLottoNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
