package lotto.domain;

import java.util.List;

public class LottoTicket {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LENGTH_OF_NUMBERS = 6;

    private final List<Integer> numbers;

    LottoTicket(List<Integer> numbers) throws IllegalArgumentException {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public boolean containNumbers(int number) {
        return numbers.contains(number);
    }

    private void validateNumbers(List<Integer> numbers) throws IllegalArgumentException {
        if (!isValidSizeOfNumbers(numbers)) {
            throw new IllegalArgumentException("6개를 숫자를 입력해야 합니다.");
        }

        if (!numbers.stream().allMatch(this::isValidNumber)) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 번호를 입력해야 합니다.");
        }
    }

    private boolean isValidNumber(int number) {
        return number >= 1 && number <= LottoTicket.MAX_NUMBER;
    }

    private boolean isValidSizeOfNumbers(List<Integer> numbers) {
        return numbers.size() == LottoTicket.LENGTH_OF_NUMBERS;
    }

    public int countEqualNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
