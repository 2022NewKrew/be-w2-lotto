package lotto.domain;

public enum LottoPrize {
    FIRST_PLACE(2_000_000_000, false),
    SECOND_PLACE(30_000_000, true),
    THIRD_PLACE(1_500_000, false),
    FOURTH_PLACE(50_000, false),
    FIFTH_PLACE(5_000, false),
    NONE(0, false);

    private final int reward;
    private final boolean bonus;

    LottoPrize(int reward, boolean bonus) {
        this.reward = reward;
        this.bonus = bonus;
    }

    public static LottoPrize from(int matchedCount, boolean bonus) {
        switch (matchedCount) {
            case 3: return FIFTH_PLACE;
            case 4: return FOURTH_PLACE;
            case 5: return THIRD_PLACE;
            case 6: return (bonus ? SECOND_PLACE : FIRST_PLACE);
            default: return NONE;
        }
    }

    public final int getReward() { return reward; }
}
