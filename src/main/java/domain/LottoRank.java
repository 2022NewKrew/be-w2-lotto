package domain;

public enum LottoRank {
    ETC(3, false, 5000L),
    FOURTH(4, false, 50000L),
    THIRD(5, false, 1500000L),
    SECOND(5, true, 30000000L),
    FIRST(6, false, 2000000000L);

    private final int matches;
    private final boolean bonus;
    private final long price;

    LottoRank(int matches, boolean bonus, long price) {
        this.matches = matches;
        this.bonus = bonus;
        this.price = price;
    }

    public int getMatches() {
        return matches;
    }

    public boolean isBonus() {
        return bonus;
    }

    public long getPrice() {
        return price;
    }
}
