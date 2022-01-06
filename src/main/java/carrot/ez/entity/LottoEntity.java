package carrot.ez.entity;

import carrot.ez.lotto.LotteryDiv;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static carrot.ez.constants.LottoConstant.*;
import static carrot.ez.constants.LottoConstant.LOTTO_NUMBERS_SIZE;

public class LottoEntity {
    private final List<Integer> numbers;
    private final LotteryDiv div;

    public LottoEntity(List<Integer> numbers, LotteryDiv div) {
        validate(numbers);
        this.numbers = numbers;
        this.div = div;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean checkBound = numbers.stream()
                .allMatch(number -> number >= MIN && number <= MAX);

        if (!checkBound) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }

    public int getNumOfCorrect(List<Integer> winNums) {
        return winNums.stream()
                .reduce(0, (total, num) -> contains(num) ? total + 1 : total);
    }

    public boolean isCorrectBonus(int bonus) {
        return contains(bonus);
    }

    private boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
