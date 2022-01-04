package com.kakao.lottogame.service;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.LottoNumber;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomLottoGenerator implements LottoGenerator {

    private final Random random;

    public RandomLottoGenerator() {
        random = new Random();
    }

    public RandomLottoGenerator(long seed) {
        random = new Random(seed);
    }

    @Override
    public Lotto generate() {
        List<LottoNumber> lottoNumbers = random.ints(LottoNumber.MIN_VALUE,
                LottoNumber.MAX_VALUE + 1)
            .distinct().limit(Lotto.SIZE).sorted()
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList());
        return Lotto.of(lottoNumbers);
    }
}
