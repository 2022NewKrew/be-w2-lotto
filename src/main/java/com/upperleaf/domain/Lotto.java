package com.upperleaf.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> numbers;

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;

    /**
     * 로또 표현 객체
     * @param numbers 로또를 표현하는 숫자 리스트
     */
    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createRandomLotto() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_START_NUM, LOTTO_END_NUM).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, LOTTO_SIZE));
    }

    public long match(List<Integer> winningNumbers) {
        return numbers.stream().filter(winningNumbers::contains).count();
    }

    public String getLottoInfo() {
        return numbers.toString();
    }
}
