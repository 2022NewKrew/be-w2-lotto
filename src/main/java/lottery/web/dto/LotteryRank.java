package lottery.web.dto;

public enum LotteryRank {
    FIRST(6, 200000000),
    SECOND_BONUS(-1, 50000000),
    SECOND(5, 30000000),
    THIRD(4, 1500000),
    FOURTH(3, 50000);

    private int matchCnt;
    private int reward;

    LotteryRank(int matchCnt, int reward) {
        this.matchCnt = matchCnt;
        this.reward = reward;
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public int getReward() {
        return reward;
    }
}
