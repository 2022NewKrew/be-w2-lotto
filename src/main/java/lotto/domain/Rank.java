package lotto.domain;

public enum Rank {
    FIFTH(3, 5000, 0),
    FOURTH(4, 50000, 0),
    THIRD(5,1500000, 0),
    SECOND(5, 30000000, 0),
    FIRST(6, 2000000000, 0);

    private final int matchingNumber;
    private final int prizeAmount;
    private int winnerCount;

    Rank(int matchingNumber, int prizeAmount, int winnerCount) {
        this.matchingNumber = matchingNumber;
        this.prizeAmount = prizeAmount;
        this.winnerCount = winnerCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public void addWinnerCount() {
        winnerCount++;
    }

    public String getResultString() {
        if (this == Rank.SECOND) {
            return String.format("%s개 일치, 보너스 볼 일치(%s원)- %s개", matchingNumber, prizeAmount, winnerCount);
        }
        return String.format("%s개 일치 (%s원)- %s개", matchingNumber, prizeAmount, winnerCount);
    }

    public static Rank valueOf(int matchingNumber, boolean hasBonusNumber) {
        if (matchingNumber == 5 && hasBonusNumber) {
            return Rank.SECOND;
        }
        for (Rank rank : Rank.values()) {
            if (rank.matchingNumber == matchingNumber) {
                return rank;
            }
        }
        return null;
    }
}

