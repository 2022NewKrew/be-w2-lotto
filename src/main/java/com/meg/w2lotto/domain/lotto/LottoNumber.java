package com.meg.w2lotto.domain.lotto;

import com.meg.w2lotto.constants.LottoConstant;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final List<LottoNumber> numbers = IntStream.range(LottoConstant.LOTTO_NUMBER_MIN, LottoConstant.LOTTO_NUMBER_MAX + 1)
            .boxed()
            .map(LottoNumber::new)
            .toList();
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int n) {
        return numbers.get(n-1);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNumber otherNumber) {
        return this.number - otherNumber.number;
    }

}
