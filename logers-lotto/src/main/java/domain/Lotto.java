package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBER_OF_WRITE_NUMBER = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> randomNumbers) {
        numbers = new ArrayList<>(randomNumbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "["
                .concat(numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","))
                ).concat("]");
    }
}
