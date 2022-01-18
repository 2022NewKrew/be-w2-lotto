package lotto.domain;

import lotto.util.Util;

import java.util.Objects;

class LottoNumberRangeException extends RuntimeException {
    LottoNumberRangeException(String msg){
        super(msg);
    }
}

public class LottoNumber {

    private int lottoNumber;

    private LottoNumber(int inputNumber){
        this.lottoNumber = inputNumber;
        validateLottoNumber();
    }

    public static LottoNumber of(int inputNumber){
        return new LottoNumber(inputNumber);
    }

    private void validateLottoNumber(){
        if (lottoNumber < 1 || lottoNumber > Util.LOTTONUMBERLIMIT){
            throw new LottoNumberRangeException("LottoGames 숫자의 범위를 넘어섰습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    //    public boolean equals(LottoNumber inputLottoNumber){
//        if (inputLottoNumber.getLottoNumber() == lottoNumber){
//            return true;
//        }
//        return false;
//    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
