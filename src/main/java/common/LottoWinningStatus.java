package common;

import java.util.Arrays;

public enum LottoWinningStatus {
    TREE_WINNING(3),
    FOUR_WINNING(4),
    FIVE_WINNING(5),
    FIVE_AND_BONUS_WINNING(5, true),
    SIX_WINNING(6),
    NORMAL,
    BANG;

    private final int winningCount;
    private final boolean bonus;

    LottoWinningStatus() {
        this.winningCount = 0;
        this.bonus = false;
    }

    LottoWinningStatus(int winningCount) {
        this.winningCount = winningCount;
        this.bonus = false;
    }

    LottoWinningStatus(int winningCount, boolean bonus) {
        this.winningCount = winningCount;
        this.bonus = bonus;
    }

    public static LottoWinningStatus find(int winningCount, boolean bonus) {
        boolean checkBonus = winningCount == 5 && bonus;
        return Arrays.stream(values())
                .filter(lottoWinningStatus ->
                        lottoWinningStatus.winningCount == winningCount && lottoWinningStatus.bonus == checkBonus)
                .findAny()
                .orElse(BANG);
    }
}
