package domain;

import enums.LottoConstants;
import exceptions.InvalidLottoNumber;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import messages.ErrorMessage;
import validation.Validation;

public class LottoNumber implements Comparable<LottoNumber> {

    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(LottoConstants.MIN_LOTTO_NUMBER.get(), LottoConstants.MAX_LOTTO_NUMBER.get() + 1)
                .forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
    }

    public static LottoNumber from(int number) {
        Validation.notLessThanLong(number, LottoConstants.MIN_LOTTO_NUMBER.get(),
                () -> new InvalidLottoNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));
        Validation.notMoreThanLong(number, LottoConstants.MAX_LOTTO_NUMBER.get(),
                () -> new InvalidLottoNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));
        if (lottoNumberCache.containsKey(number)) {
            return lottoNumberCache.get(number);
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
