package domain;

public enum Ranking implements Comparable<Ranking> {
    NONE("0", 0),
    THREE("3개 일치", 5000),
    FOUR("4개 일치", 50000),
    FIVE("5개 일치", 1500000),
    SIX_SECOND("5개 일치, 보너스 볼 일치", 30000000),
    SIX("6개 일치", 2000000000);
    private final String matchCount;
    private final int winingPrize;

    Ranking(String matchCount, int winingPrize) {
        this.matchCount = matchCount;
        this.winingPrize = winingPrize;
    }

    public String getMatchCount() {
        return matchCount;
    }

    public int getWiningPrize() {
        return winingPrize;
    }
}
