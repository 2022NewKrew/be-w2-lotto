package domain;

import enums.Rank;

public class Result {
    private final int hitCount;
    private final boolean bonus;
    private Rank resultRank;

    public Result(int hitCount, boolean bonus) {
        this.hitCount = hitCount;
        this.bonus = bonus;
        getRank();
    }

    public void getRank() {
        this.resultRank = Rank.getRank(hitCount, bonus);
    }

    public Rank getResultRank() {
        return resultRank;
    }
}
