package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(2_000_000_000L, 6),
    SECOND(30_000_000L, 5, true),
    THIRD(1_500_000L, 5),
    FOURTH(50_000L, 4),
    FIFTH(5_000L, 3),
    SIXTH(0L, 2),
    SEVENTH(0L, 1),
    NOTHING(0L, 0),
    ;

    private final long money;
    private final int matchedCount;
    private final boolean bonusBallMatched;

    Prize(long money, int matchedCount) {
        this(money, matchedCount, false);
    }

    Prize(long money, int matchedCount, boolean bonusBallMatched) {
        this.money = money;
        this.matchedCount = matchedCount;
        this.bonusBallMatched = bonusBallMatched;
    }

    public long getMoney() {
        return this.money;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 %s (%d원)", matchedCount, ( bonusBallMatched ? "+ 보너스 볼" : ""), money);
    }

    public static Prize getPrize(int matchedCount, boolean bonusBallMatched) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchedCount == matchedCount)
                .filter(prize -> prize.bonusBallMatched == bonusBallMatched)
                .findFirst()
                .orElse(NOTHING);
    }
}
