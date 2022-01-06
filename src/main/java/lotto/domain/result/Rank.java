package lotto.domain.result;

import java.util.Arrays;

public enum Rank {
    FAILED(-1, -1L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5,1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    private static final String BLANK = "";
    private static final String SECOND_STRING_FORMAT = "%s개 일치, 보너스 볼 일치(%s원)- ";
    private static final String NOT_SECOND_STRING_FORMAT = "%s개 일치 (%s원)- ";

    private final int matchingNumber;
    private final long prizeAmount;

    Rank(int matchingNumber, long prizeAmount) {
        this.matchingNumber = matchingNumber;
        this.prizeAmount = prizeAmount;
    }

    public static Rank valueOf(int matchingNumber, boolean hasBonusNumber) {
        if (matchingNumber == 5 && hasBonusNumber) {
            return Rank.SECOND;
        }
        return Arrays.stream(values()).filter(rank -> rank.matchingNumber == matchingNumber).findAny().orElse(FAILED);
    }

    public String toString() {
        if (this == Rank.FAILED) {
            return BLANK;
        }
        if (this == Rank.SECOND) {
            return String.format(SECOND_STRING_FORMAT, matchingNumber, prizeAmount);
        }
        return String.format(NOT_SECOND_STRING_FORMAT, matchingNumber, prizeAmount);
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }
}
