package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FAILED(-1, -1L, -1),
    FIFTH(3, 5_000L, 0),
    FOURTH(4, 50_000L, 0),
    THIRD(5,1_500_000L, 0),
    SECOND(5, 30_000_000L, 0),
    FIRST(6, 2_000_000_000L, 0);

    private static final String BLANK = "";
    private static final String SECOND_STRING_FORMAT = "%s개 일치, 보너스 볼 일치(%s원)- %s개%n";
    private static final String NOT_SECOND_STRING_FORMAT = "%s개 일치 (%s원)- %s개%n";

    private final int matchingNumber;
    private final long prizeAmount;
    private int winnerCount;

    Rank(int matchingNumber, long prizeAmount, int winnerCount) {
        this.matchingNumber = matchingNumber;
        this.prizeAmount = prizeAmount;
        this.winnerCount = winnerCount;
    }

    public static Rank valueOf(int matchingNumber, boolean hasBonusNumber) {
        if (matchingNumber == 5 && hasBonusNumber) {
            return Rank.SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchingNumber == matchingNumber).findAny().orElse(FAILED);
    }

    public static String printStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : Rank.values()) {
            sb.append(rank.getResultString());
        }
        return sb.toString();
    }

    private String getResultString() {
        if (this == Rank.FAILED) {
            return BLANK;
        }
        if (this == Rank.SECOND) {
            return String.format(SECOND_STRING_FORMAT, matchingNumber, prizeAmount, winnerCount);
        }
        return String.format(NOT_SECOND_STRING_FORMAT, matchingNumber, prizeAmount, winnerCount);
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public void addWinnerCount() {
        winnerCount++;
    }
}

