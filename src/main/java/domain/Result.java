package domain;
import enums.Rank;

public class Result {
    private int hitCount ;
    private boolean hitBonus;
    private Rank hitRank;

    public Result(int hitCount,Boolean hitBonus){
        this.hitCount = hitCount;
        this.hitBonus = hitBonus;
        getRank();
    }

    public void getRank(){
        Rank[] ranks = Rank.values();
        for(Rank rank : ranks){
            isHitRank(rank, hitCount);
        }
        if( hitRank.equals(Rank.THIRD) && hitBonus){
            hitRank = Rank.SECOND;
        }
    }

    public void isHitRank(Rank rank, int hitCount){
        if(rank.getCountOfMatch() == hitCount){
            this.hitRank = rank;
        }
    }

    public Rank getHitRank(){
        return hitRank;
    }
}
