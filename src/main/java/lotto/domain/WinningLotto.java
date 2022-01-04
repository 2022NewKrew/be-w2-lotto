package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;

    public WinningLotto() {
        this(new Lotto());
    }

    public WinningLotto(List<Integer> numbers) {
        this(new Lotto(numbers));
    }

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }
}
