package lotto.model;

public enum LottoPrize {
    FIRST_PLACE(2_000_000_000, "6개 일치"),
    SECOND_PLACE(30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD_PLACE(1_500_000, "5개 일치"),
    FOURTH_PLACE(50_000, "4개 일치"),
    FIFTH_PLACE(5_000, "3개 일치");

    private final int reward;
    private final String msg;
    LottoPrize(int reward, String msg) {
        this.reward = reward;
        this.msg = msg;
    }

    public static LottoPrize of(int matchedCount) {
        switch(matchedCount) {
            case 3: return FIFTH_PLACE;
            case 4: return FOURTH_PLACE;
            case 5: return THIRD_PLACE;
            case 6: return SECOND_PLACE;// 보너스볼 포함 6개 일치
            case 7: return FIRST_PLACE; // 보너스볼 제외 6개 일치
            default: return null;
        }
    }

    public final int getReward() { return reward; }

    public final String getMessage() { return msg;}
}
