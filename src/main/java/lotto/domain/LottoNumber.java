package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 45;

    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(MIN_VALUE, MAX_VALUE + 1)
                .forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
    }

    private int number;

    private LottoNumber(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException("1~45 사이의 값을 입력해야합니다.");
        }
        this.number = number;
    }

    public static LottoNumber from(int number) {
        if (lottoNumberCache.containsKey(number)) {
            return lottoNumberCache.get(number);
        }
        return new LottoNumber(number);
    }

    private static boolean isValidRange(int number) {
        return number >= MIN_VALUE && number <= MAX_VALUE;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
