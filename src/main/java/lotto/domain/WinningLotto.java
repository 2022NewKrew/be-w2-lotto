package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;

    public WinningLotto(List<Integer> numbers) {
        this(new Lotto(numbers));
    }

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public Reward matchResult(Lotto targetLotto) {
        int matchCount = lotto.matchCount(targetLotto);
        return Reward.valueOf(matchCount);
    }
}
