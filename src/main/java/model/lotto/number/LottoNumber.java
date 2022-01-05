package model.lotto.number;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static int START_NUMBER = 1;
    public static int FINAL_NUMBER = 45;

    public static int convertToInt(LottoNumber lottoNumber) {
        return lottoNumber.value;
    }

    private final int value;

    public LottoNumber(int value) {
        NumberPrecondition.checkNumber(value);
        this.value = value;
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
