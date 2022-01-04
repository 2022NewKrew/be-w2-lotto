package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;

public enum LottoResult {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int numMatchingDigit;
    private final boolean bonusMatching;
    private final long reward;

    LottoResult(int numMatchingDigit, boolean bonusMatching, long reward) {
        this.numMatchingDigit = numMatchingDigit;
        this.bonusMatching = bonusMatching;
        this.reward = reward;
    }

    public static @NotNull Optional<LottoResult> getResult(int numMatchings, boolean bonusMatching) {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result.isEqual(numMatchings, bonusMatching))
                .findAny();
    }

    private boolean isEqual(int numMatchings, boolean bonusMatching) {
        return this.numMatchingDigit == numMatchings && this.bonusMatching == bonusMatching;
    }

    public int getNumMatchingDigit() {
        return numMatchingDigit;
    }

    public long getReward() {
        return reward;
    }
}
