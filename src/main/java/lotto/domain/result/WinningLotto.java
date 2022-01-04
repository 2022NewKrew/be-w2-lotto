package lotto.domain.result;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class WinningLotto implements Lotto {

    private final List<Integer> numbers;

    public WinningLotto(List<Integer> list) {
        this.numbers = list;
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

}
