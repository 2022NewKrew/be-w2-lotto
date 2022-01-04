package step2.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    // 로또 번호 개수 6개
    public static final int THE_NUMBER_OF_LOTTO = 6;
    // 로또 최대 숫자
    public static final int LOTTO_MAX_NUM = 45;
    // 로또 최소 숫자
    public static final int LOTTO_MIN_NUM = 1;

    // 6개 번호를 담은 리스트
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        verifyNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    // 로또 번호 검증
    private void verifyNumbers(List<Integer> numbers) {
        numbers.stream()
                .forEach(num -> { if (num < 1 || num > 45) throw new NumberFormatException("1 ~ 45의 숫자만 허용됩니다.");});
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
