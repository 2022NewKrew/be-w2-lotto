package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
