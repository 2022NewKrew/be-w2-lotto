package bin.jaden.be_w2_lotto.data;

public enum LottoRankEnum {
    LOTTO_MATCH_NONE(0, 5000),
    LOTTO_MATCH_3(3, 5000),
    LOTTO_MATCH_4(4, 50000),
    LOTTO_MATCH_5(5, 1500000),
    LOTTO_MATCH_5B(5, 30000000),
    LOTTO_MATCH_6(6, 2000000000);

    final int matchCount;
    final long reward;

    LottoRankEnum(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRankEnum getRank(int count, boolean isBonus) {
        String rank = "LOTTO_MATCH_" + count + (isBonus ? "B" : "");
        try {
            return valueOf(rank);
        } catch (IllegalArgumentException illegalArgumentException) {
            return LOTTO_MATCH_NONE;
        }
    }

    public String getPrintString(int count) {
        if (this == LottoRankEnum.LOTTO_MATCH_5B) {
            return String.format(Constants.PRINT_2ND_RESULT_FORMAT, matchCount, reward, count);
        }
        return String.format(Constants.PRINT_RESULT_FORMAT, matchCount, reward, count);
    }

    public long getReward() {
        return reward;
    }
}
