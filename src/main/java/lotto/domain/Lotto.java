package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numberList;

    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public String numberListToString() {
        return numberList.toString();
    }

    public int checkLotto(List<Integer> winningNumberList) {
        return (int) numberList.stream().filter(winningNumberList::contains).count();
    }
}
