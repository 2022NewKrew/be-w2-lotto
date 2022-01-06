package common;

import java.util.Arrays;

/**
 * Lotto 상태정보를 가지고 있는 enum 입니다.
 */
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

    /**
     *
     * @param winningCount 맞춘 회수를 입력합니다.
     * @param bonus 보너스 번호를 맞춘 여부를 입력합니다.
     * @return 맞춘 번호와 보너스번호 여부에따라 enum을 반환합니다.
     */
    public static LottoWinningStatus find(int winningCount, boolean bonus) {
        boolean checkBonus = winningCount == 5 && bonus;
        return Arrays.stream(values())
                .filter(lottoWinningStatus ->
                        lottoWinningStatus.winningCount == winningCount && lottoWinningStatus.bonus == checkBonus)
                .findAny()
                .orElse(BANG);
    }
}
