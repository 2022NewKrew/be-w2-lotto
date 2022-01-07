package lotto.domain.constant;

import java.util.Arrays;

public enum Rank {
    RANK5(3, false),
    RANK4(4, false),
    RANK3(5, false),
    RANK2(5, true),
    RANK1(6, false),
    FAILED(0, false);

    private final long numberOfMatches;
    private final boolean bonus;

    Rank(long numberOfMatches, boolean bonus) {
        this.numberOfMatches = numberOfMatches;
        this.bonus = bonus;
    }

    public long getNumberOfMatches() {
        return numberOfMatches;
    }

    public boolean getBonus() {
        return bonus;
    }

    public static Rank of(long numberOfMatches, boolean bonus) {
        return Arrays.stream(values())
                .filter(type -> type.valuesEqualTo(numberOfMatches, bonus))
                .findFirst()
                .orElse(FAILED);
    }

    private boolean valuesEqualTo(long numberOfMatches, boolean bonus) {
        return this.numberOfMatches == numberOfMatches && (!this.bonus || this.bonus == bonus);
    }
}
