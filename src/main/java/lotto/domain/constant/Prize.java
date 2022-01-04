package lotto.domain.constant;

import java.util.Arrays;

public enum Prize {
    PRIZE5(Rank.RANK5, 5000),
    PRIZE4(Rank.RANK4, 50000),
    PRIZE3(Rank.RANK3, 1500000),
    PRIZE2(Rank.RANK2, 30000000),
    PRIZE1(Rank.RANK1, 2000000000),
    FAILED(Rank.FAILED, 0);

    private final Rank rank;
    private final int winnings;

    Prize(Rank rank, int winnings) {
        this.rank = rank;
        this.winnings = winnings;
    }

    public Rank getRank() {
        return rank;
    }

    public int getWinnings() {
        return winnings;
    }

    public static Prize of(Rank type) {
        return Arrays.stream(values())
                .filter(value -> type.equals(value.rank))
                .findFirst()
                .orElse(FAILED);
    }
}

