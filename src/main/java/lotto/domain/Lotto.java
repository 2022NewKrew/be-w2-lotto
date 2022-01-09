package lotto.domain;

import java.util.List;
import java.util.Optional;


public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Optional<List<Integer>> getNumbers() {
        return Optional.ofNullable(numbers);
    }

}
