package carrot.ez.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottery {
    public static final int LOTTO_PRICE = 1000;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;
    private final LotteryDiv div;

    public Lottery(List<Integer> numbers, LotteryDiv div) {
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

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int getNumOfCorrect(List<Integer> winNums) {
        return winNums.stream()
                .reduce(0, (total, num) -> contains(num) ? total + 1 : total);
    }

    public boolean isCorrectBonus(int bonus) {
        return contains(bonus);
    }

    public boolean isAuto() {
        return div == LotteryDiv.AUTO;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer number : numbers) {
            sb.append(number).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "]");
        return sb.toString();
    }
}
