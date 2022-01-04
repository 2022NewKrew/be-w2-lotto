package domain;

import java.util.List;

public class Lottery {
    private static final int MIN_MATCHING_POINT = 3;
    private static final int MAX_MATCHING_POINT = 6;

    private List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareNumbers(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : winningNumbers) {
            count += numbers.contains(number) ? 1 : 0;
        }
        if (count >= MIN_MATCHING_POINT) {
            return MAX_MATCHING_POINT - count + 1;
        }
        return 0;
    }
}

