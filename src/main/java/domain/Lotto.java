package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numberList;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    /*자동 생성 하는 경우*/
    public Lotto() {
        numberList = LottoGenerator.getLottoNumbers();
    }
    /*수동 생성 하는 경우*/
    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public int countMatchNumber(List<Integer> winningNumber) {
        return (int) numberList.stream().filter(t -> winningNumber.contains(t)).count();
    }

    public Boolean countBonusNumber(Integer bonusNumber) {
        return numberList.contains(bonusNumber);
    }
}
