package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream().sorted().collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
