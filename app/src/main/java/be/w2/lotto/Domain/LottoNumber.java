package be.w2.lotto.Domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    public LottoNumber(int number) {
        if (!(START_NUMBER <= number && number <= END_NUMBER)) {
            throw new IllegalArgumentException("로또 숫자는 1이상 45이하의 수여야만 합니다!");
        }
        this.number = number;
    }

    public LottoNumber(LottoNumbers lottoNumbers, int number) {
        this(number);
        if (lottoNumbers.contains(this)) {
            throw new IllegalArgumentException("중복되는 번호가 존재합니다!");
        }
    }

    public String toString() {
        return String.valueOf(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
