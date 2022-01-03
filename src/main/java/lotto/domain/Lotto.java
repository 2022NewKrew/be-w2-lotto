package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {
    public static final int LENGTH = 6;

    private static final Random random = new Random();
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>();
        for (int i = 0; i < LENGTH; i++) {
            int nextNum = i == 0 ? randomNum() : nextNum();
            this.numbers.add(nextNum);
        }
        Collections.sort(this.numbers);
    }

    private int randomNum() {
        return random.nextInt(44) + 1;
    }

    private int nextNum() {
        int result = this.numbers.get(0);
        while (this.numbers.contains(result)) {
            result = randomNum();
        }
        return result;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
