package domain;

import java.util.ArrayList;

public class Lotto {
    private final ArrayList<Integer> numbers;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public Lotto(ArrayList<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(ArrayList<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개로 이루어져야 합니다.");
        }
    }

    private void validateNumberRange(ArrayList<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("숫자는 1이상 45이하여야 합니다.");
        }
    }


    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
