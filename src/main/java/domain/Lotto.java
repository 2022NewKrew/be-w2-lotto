package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Lotto{
    private final ArrayList<Number> numberList;

    public Lotto(ArrayList<Number> numberList) {
        this.numberList = numberList;
    }

    @Override
    public String toString() {
        String lotto = Arrays.toString(numberList.toArray());
        return lotto;
    }

    public ArrayList<Number> getNumberList() {
        return this.numberList;
    }

    public int getHitCount(Lotto winningLotto) {
        int hitCount = 0;
        ArrayList<Number> winningLottoNumberList = winningLotto.getNumberList();
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
