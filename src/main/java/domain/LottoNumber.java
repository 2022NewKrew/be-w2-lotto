package domain;

import java.util.Objects;

import static domain.Constants.MAX_NUMBER;
import static domain.Constants.MIN_NUMBER;

public class LottoNumber {

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
