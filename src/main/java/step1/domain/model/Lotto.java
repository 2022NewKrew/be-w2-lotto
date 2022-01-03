package step1.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto() {
        this.lotto = new ArrayList<>();
    }

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public boolean isContainedThisNumber(int number) {
        return lotto.contains(number);
    }

    @Override
    public String toString() {
        return lotto.toString() + "\n";
    }
}
