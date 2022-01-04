package lotto.domain;

import java.util.List;

import static lotto.domain.LottoInfo.*;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusBall;

    public WinningLotto(List<Integer> numbers, int bonusBall) {
        this.numbers = numbers;
        this.bonusBall = bonusBall;
        validateWinningNumbers();
        validateBonusBall();
    }

    private void validateWinningNumbers() {
        if (numbers.size() != COUNT_OF_NUMBER.getValue()) {
            throw new IllegalArgumentException("당첨 번호는 6개 입니다.");
        }
        numbers.forEach(this::validateRange);
        validateDuplicate(numbers.size() != numbers.stream().distinct().count());
    }

    private void validateBonusBall() {
        validateRange(bonusBall);
        validateDuplicate(numbers.contains(bonusBall));
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("번호의 범위는 1~45 입니다.");
        }
    }

    private void validateDuplicate(boolean isInvalid) {
        if (isInvalid) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}