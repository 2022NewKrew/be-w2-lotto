package lotto.domain;

public enum LottoResult {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int reward;

    LottoResult(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoResult valueOf(int matchCount) {
        if (matchCount == 6) {
            return LottoResult.FIRST;
        }
        if (matchCount == 5) {
            return LottoResult.SECOND;
        }
        if (matchCount == 4) {
            return LottoResult.THIRD;
        }
        if (matchCount == 3) {
            return LottoResult.FOURTH;
        }
        return LottoResult.NONE;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
