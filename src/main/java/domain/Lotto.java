package domain;

import java.util.Arrays;
import java.util.List;

import static utils.Symbol.INVALID_LOTTO_FORMAT;

public class Lotto {
    private final List<Number> numberList;

    public Lotto(List<Number> numberList) {
        isValidNumberList(numberList);
        this.numberList = numberList;
    }

    public void isValidNumberList(List<Number> numberList) {
        if (!isLengthSix(numberList)) {
            throw new IllegalArgumentException(INVALID_LOTTO_FORMAT);
        }
    }

    public boolean isLengthSix(List<Number> numberList) {
        return numberList.size() == 6;
    }

    @Override
    public String toString() {
        String lotto = Arrays.toString(numberList.toArray());
        return lotto;
    }

    public List<Number> getNumberList() {
        return this.numberList;
    }

    public int getHitCount(Lotto winningLotto) {
        int hitCount = 0;
        List<Number> winningLottoNumberList = winningLotto.getNumberList();
        for (Number number : winningLottoNumberList) {
            hitCount += isHit(number);
        }
        return hitCount;
    }

    public int isHit(Number bonusNumber) {
        int hit = (numberList.contains(bonusNumber)) ? 1 : 0;
        return hit;
    }


}
