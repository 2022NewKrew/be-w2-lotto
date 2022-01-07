package domain;

import enums.Rank;

public class Result {
    private final int hitCount;
    private final boolean bonus;
    private Rank resultRank;

    public Result(int hitCount, Boolean hitBonus) {
        this.hitCount = hitCount;
        this.bonus = hitBonus;
        getRank();
    }

    public void getRank() {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            isHitRank(rank, hitCount);
        }
        if (resultRank.equals(Rank.THIRD) && bonus) {
            resultRank = Rank.SECOND;
        }
    }

    public void isHitRank(Rank rank, int hitCount) {
        if (rank.getCountOfMatch() == hitCount) {
            this.resultRank = rank;
        }
    }

    public Rank getResultRank() {
        return resultRank;
    }
}
