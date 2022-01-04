package lotto.domain.constant;

import java.util.Arrays;

public enum Rank {
    RANK5(3, false),
    RANK4(4, false),
    RANK3(5, false),
    RANK2(5, true),
    RANK1(6, false),
    FAILED(0, false);

    private final int numberOfMatches;
    private final boolean bonus;

    Rank(int numberOfMatches, boolean bonus) {
        this.numberOfMatches = numberOfMatches;
        this.bonus = bonus;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public boolean getBonus() {
        return bonus;
    }

    public static Rank of(int numberOfMatches, boolean bonus) {
        return Arrays.stream(values())
                .filter(type -> type.valuesEqualTo(numberOfMatches, bonus))
                .findFirst()
                .orElse(FAILED);
    }

    private boolean valuesEqualTo(int numberOfMatches, boolean bonus) {
        return this.numberOfMatches == numberOfMatches && (!this.bonus || this.bonus == bonus);
    }
}
