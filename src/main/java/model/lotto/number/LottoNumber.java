package model.lotto.number;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int START_NUMBER = 1;
    public static final int FINAL_NUMBER = 45;

    public static int convertToInt(LottoNumber lottoNumber) {
        return lottoNumber.value;
    }

    private final int value;

    public LottoNumber(int value) {
        checkNumber(value);

        this.value = value;
    }

    private void checkNumber(int number) {
        if (isLegalNumber(number)) {
            return;
        }
        throw new IllegalArgumentException(generateExceptionMessage());
    }

    private boolean isLegalNumber(int number) {
        return number <= LottoNumber.FINAL_NUMBER && number >= LottoNumber.START_NUMBER;
    }

    private String generateExceptionMessage() {
        return "올바른 범위의 정수를 입력해주세요. 정수의 범위는 "
                + LottoNumber.START_NUMBER
                + " 부터 "
                + LottoNumber.FINAL_NUMBER
                + " 까지입니다.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return value == lottoNumber1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber otherLottoNumber) {
        return Integer.compare(this.value, otherLottoNumber.value);
    }
}
