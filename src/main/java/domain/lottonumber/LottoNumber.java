package domain.lottonumber;

import constant.Constants;

import java.util.Objects;

public abstract class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
        validateLottoNumber();
    }

    private void validateLottoNumber() {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalStateException("로또 번호는 1~45 까지의 번호중에 입력하실수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass() && getClass().getSuperclass() != o.getClass().getSuperclass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    public abstract boolean isBonusNumber();

}
