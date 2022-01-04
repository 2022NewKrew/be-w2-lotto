package domain;

public enum Ranking {

    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FORTH(5000, 3),
    FAIL(0, 0);

    private final int sameNumber;
    private final int price;

    Ranking(int price, int sameNumber){
        this.sameNumber = sameNumber;
        this.price = price;
    }

    public int getPrice() { return this.price; }
    public int getSameNumber() {return sameNumber;}

    public boolean isEqual(int sameNumber) { return this.sameNumber == sameNumber; }

    public static Ranking valueOf(int sameNumber) {
        for( Ranking rank : Ranking.values()){
            if(rank.isEqual(sameNumber)){
                return rank;
            }
        }
        return FAIL;
    }

}
