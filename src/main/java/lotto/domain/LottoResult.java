package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;

public enum LottoResult {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int numMatchingDigit;
    private final long reward;

    LottoResult(int numMatchingDigit, int reward) {
        this.numMatchingDigit = numMatchingDigit;
        this.reward = reward;
    }

    public static @NotNull Optional<LottoResult> getResult(int numMatchings) {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result.isEqual(numMatchings))
                .findAny();
    }

    private boolean isEqual(int numMatchings) {
        return this.numMatchingDigit == numMatchings;
    }

    public int getNumMatchingDigit() {
        return numMatchingDigit;
    }

    public long getReward() {
        return reward;
    }
}
