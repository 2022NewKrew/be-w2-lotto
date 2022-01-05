package domain;

import java.util.List;

public class Winning {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Winning(List<Integer> numbers, int bonusNumber) {
        validateWinningNumbers(numbers, bonusNumber);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        if (numbers.size() != LottoGenerator.NUMBER_COUNT)
            throw new IllegalArgumentException("로또 당첨번호의 입력이 올바르지 않습니다.");

        numbers.forEach(number -> {
            if (number < 1 || number > LottoGenerator.LOTTO_INCLUSIVE_RANGE_END)
                throw new IllegalArgumentException("로또 범위가 올바르지 않습니다.");
        });

        if (bonusNumber < 1 || bonusNumber > LottoGenerator.LOTTO_INCLUSIVE_RANGE_END)
            throw new IllegalArgumentException("로또 범위가 올바르지 않습니다.");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
