package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        this.numbers = numbers;
    }

    public Rank getRank(List<Integer> winningNumbers, int bonusNum) {
        int countOfMatch = getCountOfMatch(winningNumbers);
        boolean matchOfBonus = numbers.contains(bonusNum);
        return Rank.valueOf(countOfMatch, matchOfBonus);
    }

    private int getCountOfMatch(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
