package lotto.domain;

import java.util.Arrays;

import static lotto.domain.RandomLottoNumberGenerator.NUMBERS_TO_PICK;

public enum Prize {
    NOTHING(0L, 0),
    SEVENTH(0L, NUMBERS_TO_PICK - 5),
    SIXTH(0L, NUMBERS_TO_PICK - 4),
    FIFTH(5_000L, NUMBERS_TO_PICK - 3),
    FOURTH(50_000L, NUMBERS_TO_PICK - 2),
    THIRD(1_500_000L, NUMBERS_TO_PICK - 1),
    SECOND(30_000_000L, NUMBERS_TO_PICK - 1, true),
    FIRST(2_000_000_000L, NUMBERS_TO_PICK),
    ;

    private final long money;
    private final int matchedCount;
    private final boolean bonusBallMatched;

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusBallMatched() {
        return bonusBallMatched;
    }

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

    /**
     * @param matchedCount     맞힌 번호 수
     * @param bonusBallMatched 보너스 볼 맞았는지 여부
     * @return 맞힌 번호와 보너스볼 여부에 따라 결정된 {@link Prize}
     */
    public static Prize of(int matchedCount, boolean bonusBallMatched) {
        // XXX: 더 깔끔하게 할 수 있는 방법?
        if (matchedCount == SECOND.matchedCount && bonusBallMatched) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(prize -> prize.matchedCount == matchedCount)
                .findFirst()
                .orElse(NOTHING);
    }
}
