package lotto.constant;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int match;
    private final long money;

    LottoRank(int match, long money) {
        this.match = match;
        this.money = money;
    }

    public int getMatch() {
        return match;
    }

    public long getMoney() {
        return money;
    }

}
