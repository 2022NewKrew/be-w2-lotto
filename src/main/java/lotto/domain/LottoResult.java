package lotto.domain;

import java.util.stream.Stream;

public enum LottoResult {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int reward;

    LottoResult(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoResult valueOf(int matchCount) {
        return Stream.of(LottoResult.values())
                .filter(result -> result.getMatchCount() == matchCount)
                .findAny()
                .orElse(LottoResult.NONE);
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
