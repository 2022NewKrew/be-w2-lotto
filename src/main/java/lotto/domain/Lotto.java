package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LENGTH = 6;

    private final List<Integer> numbers;

    public Lotto() { this.numbers = LottoGenerator.generateRandomLotto(); }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
