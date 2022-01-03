package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 45;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("1~45 사이의 값을 입력해야합니다.");
        }
        return new LottoNumber(number);
    }

    private static boolean isValid(int number) {
        return number >= MIN_VALUE && number <= MAX_VALUE;
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
