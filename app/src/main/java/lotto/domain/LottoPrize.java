package lotto.domain;

public enum LottoPrize {
    FIRST_PLACE(2_000_000_000),
    SECOND_PLACE(30_000_000),
    THIRD_PLACE(1_500_000),
    FOURTH_PLACE(50_000),
    FIFTH_PLACE(5_000),
    NONE(0);

    private final int reward;

    LottoPrize(int reward) {
        this.reward = reward;
    }

    public static LottoPrize of(int matchedCount) {
        switch (matchedCount) {
            case 3: return FIFTH_PLACE;
            case 4: return FOURTH_PLACE;
            case 5: return THIRD_PLACE;
            case 6: return SECOND_PLACE;// 보너스볼 포함 6개 일치
            case 7: return FIRST_PLACE; // 보너스볼 제외 6개 일치
            default: return NONE;
        }
    }

    public final int getReward() { return reward; }
}
