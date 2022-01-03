package com.kakao.lottogame.service;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.Number;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomLottoGenerator implements LottoGenerator {

    private static final Random random = new SecureRandom();

    public RandomLottoGenerator() {}

    @Override
    public Lotto generate() {
        List<Number> numbers = random.ints(Number.MIN_VALUE, Number.MAX_VALUE + 1)
            .distinct().limit(Lotto.SIZE).sorted()
            .mapToObj(Number::of)
            .collect(Collectors.toList());
        return Lotto.of(numbers);
    }
}
