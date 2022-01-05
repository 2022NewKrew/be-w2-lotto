package bin.jaden.be_w2_lotto.domain;

public enum LottoRankEnum {
    LOTTO_RANK_NONE(0, 5000),
    LOTTO_RANK_5TH(3, 5000),
    LOTTO_RANK_4TH(4, 50000),
    LOTTO_RANK_3RD(5, 1500000),
    LOTTO_RANK_2ND(5, 30000000),
    LOTTO_RANK_1ST(6, 2000000000);

    final int matchCount, reward;

    LottoRankEnum(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRankEnum getRank(int count, boolean isBonus) {
        if (count == LOTTO_RANK_2ND.matchCount && isBonus)
            return LOTTO_RANK_2ND;
        for (LottoRankEnum rank : LottoRankEnum.values()) {
            if (rank.matchCount == count) {
                return rank;
            }
        }
        return LOTTO_RANK_NONE;
    }

    public String getPrintString(int count) {
        if (this == LottoRankEnum.LOTTO_RANK_1ST) {
            return String.format(Constants.PRINT_RESULT_FORMAT, matchCount, reward, count);
        }
        if (this == LottoRankEnum.LOTTO_RANK_2ND) {
            return String.format(Constants.PRINT_2ND_RESULT_FORMAT, matchCount, reward, count);
        }
        return String.format(Constants.PRINT_RESULT_FORMAT, matchCount, reward, count);
    }

    public int getReward() {
        return reward;
    }
}
