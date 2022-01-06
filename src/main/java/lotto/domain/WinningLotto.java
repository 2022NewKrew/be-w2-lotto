package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this(new Lotto(numbers), bonusNumber);
    }

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Reward matchResult(Lotto targetLotto) {
        int matchCount = targetLotto.matchCount(lotto);
        boolean bonusMatch = targetLotto.bonusMatch(bonusNumber);
        return Reward.of(matchCount, bonusMatch);
    }
}
