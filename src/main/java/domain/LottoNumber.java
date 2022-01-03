package domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final String MESSAGE_CHECK_LOTTO_NUMBER = "로또번호는 1~45 범위의 정수여야 합니다.";
    private static final String NUMERIC_REGEX = "[1-9][0-9]*$";
    private static final Pattern PATTERN_NUMERIC = Pattern.compile(NUMERIC_REGEX);
    private int number;

    public LottoNumber(String number) {
        this(checkNumeric(number));
    }

    public LottoNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(MESSAGE_CHECK_LOTTO_NUMBER);
        }
        this.number = number;
    }

    private static int checkNumeric(String number) {
        number = number.trim();
        if (!PATTERN_NUMERIC.matcher(number).matches()) {
            throw new IllegalArgumentException(MESSAGE_CHECK_LOTTO_NUMBER);
        }
        return Integer.parseInt(number);
    }

    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LottoNumber otherLottoNumber = (LottoNumber) other;
        return number == otherLottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
