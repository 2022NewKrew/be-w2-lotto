package step1.domain;

public enum Rank {

    FIRST(6, 2000000000L),
    SECOND(5, 30000000L),
    THIRD(5, 1500000L),
    FOURTH(4, 50000L),
    FIFTH(3, 5000L);

    private int matchCount;
    private Long reward;

    private Rank(int matchCount, Long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Long getReward() {
        return reward;
    }
}
