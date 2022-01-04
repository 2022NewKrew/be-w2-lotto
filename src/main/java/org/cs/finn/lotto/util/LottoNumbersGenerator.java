package org.cs.finn.lotto.util;

import org.cs.finn.lotto.domain.lotto.LottoNumber;
import org.cs.finn.lotto.domain.lotto.LottoNumbers;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbersGenerator {
    private static final List<LottoNumber> list;
    static {
        list = new ArrayList<>();
        for (int i = LottoNumber.MIN; i <= LottoNumber.MAX; i++) {
            list.add(new LottoNumber(i));
        }
    }

    private LottoNumbersGenerator() {}

    public static LottoNumbers getLottoNumbers(final SecureRandom sRand) {
        Collections.shuffle(list, Objects.requireNonNull(sRand));
        Collections.sort(list.subList(0, LottoNumbers.SIZE));

        return new LottoNumbers(
                new ArrayList<>(list.subList(0, LottoNumbers.SIZE))
        );
    }
}
