package lotto.domain;

public enum LottoRank {

    BLANK(0, 0, false),
    FIFTH_PRIZE(3, 5000, false),
    FOURTH_PRIZE(4, 50000, false),
    THIRD_PRIZE(5, 1500000, false),
    SECOND_PRIZE(5, 30000000, true),
    FIRST_PRIZE(6, 2000000000, false);

    private final int matchingCnt;
    private final int reward;
    private final boolean bonus;

    LottoRank(int matchingCnt, int reward, boolean bonus) {
        this.matchingCnt = matchingCnt;
        this.reward = reward;
        this.bonus = bonus;
    }

    public int getMatchingCnt() {
        return matchingCnt;
    }

    public int getReward() {
        return reward;
    }

    public static LottoRank lookup(int matchingCnt, boolean bonus){
        for(LottoRank rank : LottoRank.values()){
            if(rank.matchingCnt == matchingCnt && rank.bonus == bonus) return rank;
        }
        return LottoRank.BLANK;
    }
}
