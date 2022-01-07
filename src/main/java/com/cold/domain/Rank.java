package com.cold.domain;

import lombok.Getter;

@Getter
public enum Rank {
    THREE(3, 5000),
    FOUR( 4, 50000),
    FIVE(5,1500000),
    BONUS(5, 30000000),
    SIX(6, 2000000000),
    EMPTY(0,0);

    private Integer matchCount;
    private Boolean bonusMatch;
    private Integer winningReward;

    Rank(Integer matchCount, Integer winningReward) {
        this.matchCount = matchCount;
        this.winningReward = winningReward;
    }

    public static String getKeyword(int matchCount, Boolean bonusMatch){
        switch(matchCount){
            case(3):
                return "THREE";
            case(4):
                return "FOUR";
            case(5):
                if(bonusMatch){
                    return "BONUS";
                }
                return "FIVE";
            case(6):
                return "SIX";
            case(7):
                return "BONUS";
            default:
                return "EMPTY";
        }
    }
}
