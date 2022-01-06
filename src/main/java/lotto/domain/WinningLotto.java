package lotto.domain;

import java.util.List;

public class WinningLotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Lotto lotto;
    private final int bonusBall;

    public WinningLotto(List<Integer> numbers, int bonusBallNumber) {
        this(new Lotto(numbers), bonusBallNumber);
    }

    public WinningLotto(Lotto lotto, int bonusBallNumber) {
        validateNumberBound(bonusBallNumber);
        this.lotto = lotto;
        this.bonusBall = bonusBallNumber;
    }

    private void validateNumberBound(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 여야 합니다.");
        }
    }

    public Reward matchResult(Lotto targetLotto) {
        int matchCount = lotto.matchCount(targetLotto);
        boolean isBonus = targetLotto.contains(bonusBall);
        return Reward.valueOf(matchCount, isBonus);
    }
}
