package lotto.domain;

import java.util.stream.Stream;

public enum LottoResult {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int reward;
    private final boolean matchBonus;

    LottoResult(int matchCount, int reward, boolean matchBonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.matchBonus = matchBonus;
    }

    public static LottoResult valueOf(int matchCount, boolean matchBonus) {
        return Stream.of(LottoResult.values())
                .filter(result -> result.isEqualToMatchCount(matchCount))
                .filter(result -> result.isEqualToMatchBonus(matchBonus))
                .findAny()
                .orElse(LottoResult.NONE);
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    private boolean isEqualToMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean isEqualToMatchBonus(boolean matchBonus) {
        return this.matchBonus == matchBonus;
    }
}
