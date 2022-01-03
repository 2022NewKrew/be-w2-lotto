package domain;

public enum LottoRank {
    FOURTH(3, 5000L),
    THIRD(4, 50000L),
    SECOND(5, 1500000L),
    FIRST(6, 2000000000L);

    private final int matches;
    private final long price;

    LottoRank(int matches, long price) {
        this.matches = matches;
        this.price = price;
    }

    public int getMatches() {
        return matches;
    }

    public long getPrice() {
        return price;
    }
}
