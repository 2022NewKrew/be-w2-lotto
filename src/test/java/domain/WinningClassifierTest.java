package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningClassifierTest {
    private final WinningClassifier[] gradeArr = WinningClassifier.values();

    private static final long FIFTH_PRICE = 5_000L;
    private static final long FORTH_PRICE = 50_000L;
    private static final long THIRD_PRICE = 1_500_000L;
    private static final long SECOND_PRICE = 30_000_000L;
    private static final long FIRST_PRICE = 2_000_000_000L;
    private static final long BOMB_PRICE = 0L;
    private static final int FIFTH_MATCH_NUMS = 3;
    private static final int FORTH_MATCH_NUMS = 4;
    private static final int THIRD_MATCH_NUMS = 5;
    private static final int SECOND_MATCH_NUMS = 5;
    private static final int FIRST_MATCH_NUMS = 6;

    @Test
    void getPrice() {
        long[] priceLst = new long[]{FIFTH_PRICE, FORTH_PRICE, THIRD_PRICE, SECOND_PRICE, FIRST_PRICE, BOMB_PRICE};
        for (int i = 0; i < gradeArr.length; i++) {
            assertThat(gradeArr[i].getPrice()).isEqualTo(priceLst[i]);
        }
    }

    @Test
    void getMatchNums() {
        int[] matchNumLst = new int[]{FIFTH_MATCH_NUMS, FORTH_MATCH_NUMS, THIRD_MATCH_NUMS, SECOND_MATCH_NUMS, FIRST_MATCH_NUMS};
        for (int i = 0; i < gradeArr.length - 1; i++) {
            assertThat(gradeArr[i].getMatchNums()).isEqualTo(matchNumLst[i]);
        }
    }

    @Test
    void isMatchBonus() {
        boolean[] hasBonusLst = new boolean[]{false, false, false, true, false, false};
        for (int i = 0; i < gradeArr.length; i++) {
            assertThat(gradeArr[i].isMatchBonus()).isEqualTo(hasBonusLst[i]);
        }
    }

    @Test
    void findMatchScoreObject() {
        assertThat(WinningClassifier.findMatchScoreObject(FIFTH_MATCH_NUMS, 1)).isEqualTo(WinningClassifier.FIFTH);
        assertThat(WinningClassifier.findMatchScoreObject(FIFTH_MATCH_NUMS, 0)).isEqualTo(WinningClassifier.FIFTH);
        assertThat(WinningClassifier.findMatchScoreObject(FORTH_MATCH_NUMS, 1)).isEqualTo(WinningClassifier.FORTH);
        assertThat(WinningClassifier.findMatchScoreObject(FORTH_MATCH_NUMS, 0)).isEqualTo(WinningClassifier.FORTH);
        assertThat(WinningClassifier.findMatchScoreObject(THIRD_MATCH_NUMS, 1)).isEqualTo(WinningClassifier.SECOND);
        assertThat(WinningClassifier.findMatchScoreObject(THIRD_MATCH_NUMS, 0)).isEqualTo(WinningClassifier.THIRD);
        assertThat(WinningClassifier.findMatchScoreObject(SECOND_MATCH_NUMS, 1)).isEqualTo(WinningClassifier.SECOND);
        assertThat(WinningClassifier.findMatchScoreObject(SECOND_MATCH_NUMS, 0)).isEqualTo(WinningClassifier.THIRD);
        assertThat(WinningClassifier.findMatchScoreObject(FIRST_MATCH_NUMS, 1)).isEqualTo(WinningClassifier.BOMB);
        assertThat(WinningClassifier.findMatchScoreObject(FIRST_MATCH_NUMS, 0)).isEqualTo(WinningClassifier.FIRST);
        assertThat(WinningClassifier.findMatchScoreObject(FIFTH_MATCH_NUMS - 1, 1)).isEqualTo(WinningClassifier.BOMB);
    }

    @Test
    void getWinObjLst() {
        List<WinningClassifier> winObjs = WinningClassifier.getWinObjLst();

        for (WinningClassifier ms : winObjs) {
            assertThat(ms).isNotEqualTo(WinningClassifier.BOMB);
        }
    }
}