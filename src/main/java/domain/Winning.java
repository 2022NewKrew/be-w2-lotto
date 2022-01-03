package domain;

import java.util.List;

public class Winning {
    private final List<Integer> numbers;

    public Winning(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
