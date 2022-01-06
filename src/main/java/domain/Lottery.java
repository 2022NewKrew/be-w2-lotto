package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lottery {
    private static final String VALIDATE_SIZE_MESSAGE = "로또 숫자는 6개여야 합니다.";
    private static final String VALIDATE_NUMBER_BOUND_MESSAGE = "로또 번호는 1 ~ 45 사이여야 합니다.";
    private static final String VALIDATE_NUMBER_REPEAT_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    private static final int LOTTERY_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersBound(numbers);
        validateNumbersRepeat(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_COUNT) {
            throw new IllegalArgumentException(VALIDATE_SIZE_MESSAGE);
        }
    }

    public void validateNumbersBound(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberBound(number);
        }
    }

    private void validateNumberBound(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_BOUND_MESSAGE);
        }
    }

    private void validateNumbersRepeat(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() < numbers.size()) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_REPEAT_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Rank compareNumbers(WinningLottery winningLottery) {
        int countOfMatch = 0;
        boolean matchBonus = numbers.contains(winningLottery.getBonusNumber());

        for (Integer number : winningLottery.getLottery().getNumbers()) {
            countOfMatch += numbers.contains(number) ? 1 : 0;
        }

        return Rank.valueOf(countOfMatch, matchBonus);
    }
}

