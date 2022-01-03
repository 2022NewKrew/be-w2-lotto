package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Lotto {
    public static final int N_NUMBERS = 6;
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != N_NUMBERS)
            throw new IllegalArgumentException();

        this.numbers = numbers;
        Collections.sort(numbers);
    }

    public int howManyMatch(Lotto targetLotto) {
        int count = 0;
        List<Integer> compareTarget = targetLotto.getNumbers();
        for (int i = 0; i < N_NUMBERS; i++) {
            count += numbers.contains(compareTarget.get(i)) ? 1 : 0;
        }
        return count;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public String toString() {
        return this.numbers.toString();
    }


}
