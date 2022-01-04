package step2.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int THE_NUMBER_OF_LOTTO = 6;
    public static final int LOTTO_MAX_NUM = 45;
    public static final int LOTTO_MIN_NUM = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        verifyNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void verifyNumbers(List<Integer> numbers) {
        numbers.stream()
                .forEach(num -> { if (num < 1 || num > 45) throw new NumberFormatException("1 ~ 45의 숫자만 허용됩니다.");});
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
