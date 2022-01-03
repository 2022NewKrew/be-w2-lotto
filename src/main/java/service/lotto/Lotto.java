package service.lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> lotto;

    protected Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
