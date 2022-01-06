package com.kakao.lottogame.service;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.LottoNumber;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoGenerator {

    private final Random random;

    public LottoGenerator() {
        random = new Random();
    }

    public LottoGenerator(long seed) {
        random = new Random(seed);
    }

    public Lotto generateAuto() {
        List<LottoNumber> lottoNumbers = random.ints(LottoNumber.MIN_VALUE,
                LottoNumber.MAX_VALUE + 1)
            .distinct()
            .limit(Lotto.SIZE)
            .sorted()
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList());
        return Lotto.of(lottoNumbers);
    }

    public Lotto generateManual(List<Integer> manualLottoNumbers) {
        List<LottoNumber> lottoNumbers = manualLottoNumbers.stream()
            .distinct()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
        return Lotto.of(lottoNumbers);
    }
}
