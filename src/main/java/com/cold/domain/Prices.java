package com.cold.domain;

import lombok.Getter;

@Getter
public enum Prices {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    BONUS(7, 30000000);

    private Integer matchValue;
    private Integer winningReward;

    Prices(Integer matchValue, Integer winningReward) {
        this.matchValue = matchValue;
        this.winningReward = winningReward;
    }
}
