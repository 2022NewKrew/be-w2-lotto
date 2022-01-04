package common.model;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FORTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    ETC(0, false, 0L);

    private int winningCount;

    private boolean needBonus;

    private Long winnings;

    LottoRank(int winningCount, boolean needBonus, Long winnings) {
        this.winningCount = winningCount;
        this.needBonus = needBonus;
        this.winnings = winnings;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public Long getWinnings() {
        return winnings;
    }

    public boolean isNeedBonus() {
        return needBonus;
    }

    public static LottoRank findLottoRankByWinningCount(int winningCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getWinningCount() == winningCount)
                .findFirst()
                .orElse(ETC);
    }

    public static LottoRank findLottoRankByWinningCountAndMatchBonus(int winningCount, boolean matchBonus) {
        if(isSecond(winningCount, matchBonus)) { return SECOND; }
        return findLottoRankByWinningCount(winningCount);
    }

    private static boolean isSecond(int winningCount, boolean matchBonus) {
        return winningCount == 5 && matchBonus;
    }
}
