package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numberList = LottoGenerator.getLottoNumbers();
    static final int lottoPrice = 1000;
    static final int START_NUMBER = 1;
    static final int END_NUMBER = 45;
    public List<Integer> getNumberList() {
        return numberList;
    }
    public int countMatchNumber(List<Integer> winningNumber) {
        return (int) numberList.stream().filter(t -> winningNumber.contains(t)).count();
    }
}
