package lotto.model;

import java.util.Collections;
import java.util.List;


public class Lotto {
    public static final int N_NUMBERS = 6;
    public static final int PRICE = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != N_NUMBERS)
            throw new IllegalArgumentException();

        this.numbers = numbers;
        Collections.sort(numbers);
    }

    public Lotto(Lotto lotto) {
        this(lotto.getNumbers());
    }

    public int howManyMatch(Lotto other) {
        int count = 0;
        for (Integer number : this.numbers) {
            count += other.getNumbers().contains(number) ? 1 : 0;
        }
        return count;
    }

    public boolean contains(Integer number){
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public String toString() {
        return this.numbers.toString();
    }


}
