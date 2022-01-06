package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numberList;
    /*자동 생성 하는 경우*/
    public Lotto() {
        this.numberList = LottoGenerator.generateLottoNumbers();
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
