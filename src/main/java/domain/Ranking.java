package domain;

public enum Ranking implements Comparable<Ranking> {
    NONE(0,0),
    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    SIX(6,2000000000);
    private final int matchCount;
    private final int winingPrize;

    Ranking(int matchCount, int winingPrize){
        this.matchCount = matchCount;
        this.winingPrize = winingPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWiningPrize() {
        return winingPrize;
    }
}
