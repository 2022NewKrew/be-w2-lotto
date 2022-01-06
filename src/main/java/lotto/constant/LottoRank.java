package lotto.constant;

public enum LottoRank {
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true,30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000),
    NOTHING(6, 0, false, 0);

    private final int rank;
    private final int match;
    private final boolean isBonus;
    private final long money;

    LottoRank(int rank, int match, boolean isBonus, long money) {
        this.rank = rank;
        this.match = match;
        this.isBonus = isBonus;
        this.money = money;
    }

    LottoRank(int match, boolean isBonus) {
        LottoRank lottoRank = generateLottoRank(match, isBonus);
        this.rank = lottoRank.rank;
        this.match = lottoRank.match;
        this.isBonus = lottoRank.isBonus;
        this.money = lottoRank.money;
    }

    private static LottoRank generateLottoRank(int match, boolean isBonus) {
        if (match == SECOND.match && isBonus)
            return SECOND;
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.match == SECOND.match) continue;
            if (lottoRank.match == match) return lottoRank;
        }
        return NOTHING;
    }

    public int getMatch() {
        return match;
    }

    public long getMoney() {
        return money;
    }

    public boolean getIsBonus() {
        return isBonus;
    }

}
