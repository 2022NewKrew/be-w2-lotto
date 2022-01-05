package step2.domain;

import step3.util.Validator;

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
        numbers.stream().forEach(Validator::FROM_1_TO_45);
        Validator.SIX_NUMBER_LIST(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
