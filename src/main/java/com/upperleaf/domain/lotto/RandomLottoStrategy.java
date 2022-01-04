package com.upperleaf.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1부터 45까지 숫자를 섞어서, 6자리의 로또 번호를 선정하는 객체
 */
public class RandomLottoStrategy implements LottoCreateStrategy {

    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    @Override
    public Lotto createLotto() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_START_NUM, LOTTO_END_NUM).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, LOTTO_SIZE));
    }
}
