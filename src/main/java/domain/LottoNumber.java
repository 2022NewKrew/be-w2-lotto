package domain;

import exceptions.InvalidLottoNumber;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import messages.ErrorMessage;
import validation.Validation;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();

    static {
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
                .forEach(i -> LOTTO_NUMBER_CACHE.put(i, new LottoNumber(i)));
    }

    public static LottoNumber from(int number) {
        Validation.notLessThanLong(number, MIN_LOTTO_NUMBER,
                () -> new InvalidLottoNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));
        Validation.notMoreThanLong(number, MAX_LOTTO_NUMBER,
                () -> new InvalidLottoNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));
        if (LOTTO_NUMBER_CACHE.containsKey(number)) {
            return LOTTO_NUMBER_CACHE.get(number);
        }
        return new LottoNumber(number);
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.get();
    }
}
