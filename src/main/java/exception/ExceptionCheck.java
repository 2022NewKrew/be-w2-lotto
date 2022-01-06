package exception;

import domain.Lotto;
import domain.LottoConst;

public class ExceptionCheck {
    public void checkLotto(Lotto lotto) throws IllegalArgumentException{
        int size = (int) lotto.getLotto().stream()
                .distinct()
                .count();

        checkLottoSize(size);
        for (Integer lottoNum : lotto.getLotto()) {
            checkLottoNumber(lottoNum);
        }
    }

    public void checkMinPrice(int price){
        if(price < LottoConst.ONE_LOTTO_PRICE){
            throw new IllegalArgumentException("최소 가격 이상 입력해야 합니다.");
        }
    }

    public void checkPositiveNumber(int number){
        if(number <= 0) {
            throw new IllegalArgumentException("0보다 작은값은 입력할 수 없습니다.");
        }
    }

    public void checkLottoNumber(int number){
        if(number < LottoConst.LOTTO_MIN_NUMBER || number > LottoConst.LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("1~45사이의 번호만 입력할 수 있습니다.");
        }
    }

    public void checkLottoSize(int size){
        if(size != LottoConst.LOTTO_SIZE){
            throw new IllegalArgumentException("중복되지 않은 6개의 번호를 입력해야 합니다.");
        }
    }
}
