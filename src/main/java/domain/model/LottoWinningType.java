package domain.model;

import java.util.Arrays;

public enum LottoWinningType {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FORTH(3, 5000),
    ETC(0, 0);

    private int winningCount;

    private int winnings;

    LottoWinningType(int winningCount, int winnings) {
        this.winningCount = winningCount;
        this.winnings = winnings;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public static LottoWinningType getWinningsWinningCount(int winningCount) {
        return Arrays.stream(LottoWinningType.values())
                .filter(winningType -> winningType.getWinningCount() == winningCount)
                .findFirst()
                .orElse(ETC);
    }
}
