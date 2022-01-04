package Lotto.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int matedNum;
    private final long earnedMoney;

    Rank(int matedNum, int earnedMoney){
        this.matedNum = matedNum;
        this.earnedMoney = earnedMoney;
    }

    public int getMatedNum(){return matedNum;}
    public long getEarnedMoney(){return earnedMoney;}

    public static Rank value(int matedNum, boolean isMatchedBonus){
       for(Rank rank : values()){
           if(matedNum == SECOND.matedNum)
               return isMatchedBonus ? SECOND : THIRD;
           if(rank.matedNum == matedNum)
               return rank;
       }
        return null;
    }
}
