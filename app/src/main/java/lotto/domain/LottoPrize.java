package lotto.domain;

public enum LottoPrize {
    FIRST_PLACE(2_000_000_000, false, 6),
    SECOND_PLACE(30_000_000, true, 5),
    THIRD_PLACE(1_500_000, false, 5),
    FOURTH_PLACE(50_000, false, 4),
    FIFTH_PLACE(5_000, false, 3),
    NONE(0, false, 0);

    private final int reward;
    private final boolean bonus;
    private final int matchedCount;

    LottoPrize(int reward, boolean bonus, int matchedCount) {
        this.reward = reward;
        this.bonus = bonus;
        this.matchedCount = matchedCount;
    }

    public static LottoPrize from(int matchedCount, boolean bonus) {
        switch (matchedCount) {
            case 3: return FIFTH_PLACE;
            case 4: return FOURTH_PLACE;
            case 5: return (bonus ? SECOND_PLACE : THIRD_PLACE);
            case 6: return FIRST_PLACE;
            default: return NONE;
        }
    }

    public final int getReward() { return reward; }

    public final int getMatchedCount() { return matchedCount; }
}
