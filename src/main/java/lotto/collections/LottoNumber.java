package lotto.collections;

import java.util.Objects;

public class LottoNumber {
    private int n;
    private static final int UPPER_BOUND=45;
    private static final int LOWER_BOUND=1;

    public LottoNumber(int n){
        if ( n> UPPER_BOUND ){
            throw new IllegalArgumentException("입력 가능한 최대 로또 번호는 "+ UPPER_BOUND + "입니다.\n");
        }
        if ( n< LOWER_BOUND ){
            throw new IllegalArgumentException("입력 가능한 최소 로또 번호는 "+LOWER_BOUND + "입니다.\n");
        }
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return n == that.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }

    @Override
    public String toString() {
        return Integer.toString(this.n);
    }
}
