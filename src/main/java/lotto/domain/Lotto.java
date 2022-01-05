package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LENGTH = 6;

    private final List<Integer> numbers;

    protected Lotto(List<Integer> numbers) { this.numbers = numbers; }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
