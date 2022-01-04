package main.java.lotto;

public enum LottoRank {
    FIRST(6,"",2000000000),
    SECOND(5,", 보너스 볼 일치",30000000),
    THIRD(5,"",1500000),
    FOURTH(4,"",50000),
    FIFTH(3,"",5000);

    private final int match;
    private final String isBonus;
    private final int earning;

    LottoRank(int match, String isBonus, int earning){
        this.match = match;
        this.isBonus = isBonus;
        this.earning = earning;
    }

    public int getMatch(){
        return match;
    }

    public String getIsBonus(){
        return isBonus;
    }

    public int getEarning(){
        return earning;
    }
}
