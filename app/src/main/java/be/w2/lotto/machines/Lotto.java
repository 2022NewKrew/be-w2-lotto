package be.w2.lotto.machines;

import java.util.Collections;
import java.util.List;

public class Lotto {

    public static int LENGTH = 6;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }
}
