package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusBall;

    public WinningLotto(List<Integer> numbers, int bonusBallNumber) {
        this(new Lotto(numbers), bonusBallNumber);
    }

    public WinningLotto(Lotto lotto, int bonusBallNumber) {
        this.lotto = lotto;
        this.bonusBall = bonusBallNumber;
    }

    public Reward matchResult(Lotto targetLotto) {
        int matchCount = lotto.matchCount(targetLotto);
        boolean isBonus = targetLotto.contains(bonusBall);
        return Reward.valueOf(matchCount, isBonus);
    }
}
