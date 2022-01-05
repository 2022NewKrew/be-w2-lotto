package domain;

import java.util.Objects;

public class LottoNumber {
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
        validateNumber(number);
    }

    public static LottoNumber of(int number){
        return new LottoNumber(number);
    }

    private void validateNumber(int number){
        if(number < MIN_NUMBER || number > MAX_NUMBER) throw new IllegalArgumentException();
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
