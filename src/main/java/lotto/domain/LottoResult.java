package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;

public enum LottoResult {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int numOfMatchingDigits;
    private final boolean bonusMatching;
    private final long reward;

    LottoResult(int numOfMatchingDigits, boolean bonusMatching, long reward) {
        this.numOfMatchingDigits = numOfMatchingDigits;
        this.bonusMatching = bonusMatching;
        this.reward = reward;
    }

    public static @NotNull Optional<LottoResult> getResult(int numOfMatchings, boolean bonusMatching) {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result.isEqual(numOfMatchings, bonusMatching))
                .findAny();
    }

    private boolean isEqual(int numOfMatchings, boolean bonusMatching) {
        if (numOfMatchings == SECOND.getNumOfMatchingDigits()) {
            return this.numOfMatchingDigits == numOfMatchings && this.bonusMatching == bonusMatching;
        }
        return this.numOfMatchingDigits == numOfMatchings;
    }

    public int getNumOfMatchingDigits() {
        return numOfMatchingDigits;
    }

    public long getReward() {
        return reward;
    }
}
