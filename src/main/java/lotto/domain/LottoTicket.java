package lotto.domain;

import java.util.List;

public class LottoTicket {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LENGTH_OF_NUMBERS = 6;
    public static final int PRICE = 1000;

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
            throw new IllegalArgumentException("번호는 1부터 45 사이의 번호를 입력해야 합니다.");
        }
        if (hasDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException("중복된 숫자를 가지고 있습니다.");
        }
    }

    private boolean isValidNumber(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private boolean isValidSizeOfNumbers(List<Integer> numbers) {
        return numbers.size() == LENGTH_OF_NUMBERS;
    }

    private boolean hasDuplicatedNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() != LENGTH_OF_NUMBERS;
    }

    public int countEqualNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
