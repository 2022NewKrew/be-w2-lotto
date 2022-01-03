package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FOURTH(3, 5000, 0),
    THIRD(4, 50000, 0),
    SECOND(5,1500000, 0),
    FIRST(6, 2000000000, 0);

    private final int matchingNumber;
    private final int prizeAmount;
    private int winnerCount;

    Rank(int matchingNumber, int prizeAmount, int winnerCount) {
        this.matchingNumber = matchingNumber;
        this.prizeAmount = prizeAmount;
        this.winnerCount = winnerCount;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getWinnerCount() {
        return winnerCount;
    }

    public void addWinnerCount() {
        winnerCount++;
    }

    public static Rank valueOf(int matchingNumber) {
        for (Rank rank : Rank.values()) {
            if (rank.matchingNumber == matchingNumber) {
                return rank;
            }
        }
        return null;
    }
}

