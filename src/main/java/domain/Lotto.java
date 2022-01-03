package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBER_SIZE){
            throw new IllegalArgumentException();
        }

        this.numbers = numbers;
    }
}
