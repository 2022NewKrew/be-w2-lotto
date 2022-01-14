package lotto.domain;

import lotto.util.Util;

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

    public boolean equals(LottoNumber inputLottoNumber){
        if (inputLottoNumber.getLottoNumber() == lottoNumber){
            return true;
        }
        return false;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
