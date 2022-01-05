package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        if (numbers == null)
            throw new IllegalArgumentException();
        this.numbers = Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }

    public Integer checkMatchCount(List<Integer> winningNumbers) {
        // TODO - 몇개의 번호가 일치하는지 확인
        return 6;
    }
}
