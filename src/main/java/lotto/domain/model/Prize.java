package lotto.domain.model;

public enum Prize {
    DIV4(4, 3, 5000),
    DIV3(3, 4, 50000),
    DIV2(2, 5, 1500000),
    DIV1(1, 6, 2000000000);

    private final int divisions;
    private final int numberOfMatches;
    private final int winnings;

    Prize(int divisions, int numberOfMatches, int winnings) {
        this.divisions = divisions;
        this.numberOfMatches = numberOfMatches;
        this.winnings = winnings;
    }

    public int getDivisions() {
        return divisions;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getWinnings() {
        return winnings;
    }
}

