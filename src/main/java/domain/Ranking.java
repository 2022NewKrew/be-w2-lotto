package domain;

public enum Ranking implements Comparable<Ranking> {
    NONE("0", 0),
    THREE("3개 일치", 5000),
    FOUR("4개 일치", 50000),
    FIVE("5개 일치", 1_500_000L),
    SIX_SECOND("5개 일치, 보너스 볼 일치", 30_000_000L),
    SIX("6개 일치", 2000_000_000L);
    private final String matchCount;
    private final long winingPrize;

    Ranking(String matchCount, long winingPrize) {
        this.matchCount = matchCount;
        this.winingPrize = winingPrize;
    }

    public String getMatchCount() {
        return matchCount;
    }

    public long getWiningPrize() {
        return winingPrize;
    }
}
