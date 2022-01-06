package domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Number> numberList;

    public Lotto(List<Number> numberList) {
        this.numberList = numberList;
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
