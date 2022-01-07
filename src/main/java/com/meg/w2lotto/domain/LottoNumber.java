package com.meg.w2lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final List<LottoNumber> numbers = IntStream.range(MIN, MAX + 1)
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
