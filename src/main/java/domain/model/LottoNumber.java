package domain.model;

import java.util.Objects;

public class LottoNumber {

    private final Integer number;

    public LottoNumber(Integer number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateLottoNumber(Integer number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1이상 45이하 숫자만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) { return true; }
        if(!(o instanceof LottoNumber)) { return false; }
        LottoNumber lottoNumber = (LottoNumber) o;
        return this.number == lottoNumber.number && Objects.equals(this.number, lottoNumber.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
