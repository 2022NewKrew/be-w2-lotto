package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchScoreTest {
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

    private final MatchScore[] mss = MatchScore.values();

    @BeforeEach
    void setUp() {
        MatchScore.initForTest();
    }

    @Test
    void getPrice() {
        long[] priceLst = new long[]{FIFTH_PRICE, FORTH_PRICE, THIRD_PRICE, SECOND_PRICE, FIRST_PRICE, BOMB_PRICE};
        for (int i = 0; i < mss.length; i++) {
            assertThat(mss[i].getPrice()).isEqualTo(priceLst[i]);
        }
    }

    @Test
    void getMatchNums() {
        int[] matchNumLst = new int[]{FIFTH_MATCH_NUMS, FORTH_MATCH_NUMS, THIRD_MATCH_NUMS, SECOND_MATCH_NUMS, FIRST_MATCH_NUMS};
        for (int i = 0; i < mss.length - 1; i++) {
            assertThat(mss[i].getMatchNums()).isEqualTo(matchNumLst[i]);
        }
    }

    @Test
    void isMatchBonus() {
        boolean[] hasBonusLst = new boolean[]{false, false, false, true, false, false};
        for (int i = 0; i < mss.length; i++) {
            assertThat(mss[i].isMatchBonus()).isEqualTo(hasBonusLst[i]);
        }
    }

    @Test
    void getNumLotto() {
        for (MatchScore ms : mss) {
            assertThat(ms.getNumLotto()).isEqualTo(0);
        }
    }

    @Test
    void addNumLotto() {
        for (MatchScore ms : mss) {
            int prev = ms.getNumLotto();
            ms.addNumLotto();
            assertThat(ms.getNumLotto()).isEqualTo(prev + 1);
        }
    }

    @Test
    void findMatchScoreObject() {
        assertThat(MatchScore.findMatchScoreObject(FIFTH_MATCH_NUMS, 1)).isEqualTo(MatchScore.FIFTH);
        assertThat(MatchScore.findMatchScoreObject(FIFTH_MATCH_NUMS, 0)).isEqualTo(MatchScore.FIFTH);
        assertThat(MatchScore.findMatchScoreObject(FORTH_MATCH_NUMS, 1)).isEqualTo(MatchScore.FORTH);
        assertThat(MatchScore.findMatchScoreObject(FORTH_MATCH_NUMS, 0)).isEqualTo(MatchScore.FORTH);
        assertThat(MatchScore.findMatchScoreObject(THIRD_MATCH_NUMS, 1)).isEqualTo(MatchScore.SECOND);
        assertThat(MatchScore.findMatchScoreObject(THIRD_MATCH_NUMS, 0)).isEqualTo(MatchScore.THIRD);
        assertThat(MatchScore.findMatchScoreObject(SECOND_MATCH_NUMS, 1)).isEqualTo(MatchScore.SECOND);
        assertThat(MatchScore.findMatchScoreObject(SECOND_MATCH_NUMS, 0)).isEqualTo(MatchScore.THIRD);
        assertThat(MatchScore.findMatchScoreObject(FIRST_MATCH_NUMS, 1)).isEqualTo(MatchScore.BOMB);
        assertThat(MatchScore.findMatchScoreObject(FIRST_MATCH_NUMS, 0)).isEqualTo(MatchScore.FIRST);
        assertThat(MatchScore.findMatchScoreObject(FIFTH_MATCH_NUMS - 1, 1)).isEqualTo(MatchScore.BOMB);
    }

    @Test
    void getWinObjLst() {
        List<MatchScore> winObjs = MatchScore.getWinObjLst();

        for (MatchScore ms : winObjs) {
            assertThat(ms).isNotEqualTo(MatchScore.BOMB);
        }
    }

    @Test
    void getTotalPrice() {
        assertThat(MatchScore.getTotalPrice()).isEqualTo(0L);

        for (MatchScore ms : mss) {
            ms.addNumLotto();
        }

        assertThat(MatchScore.getTotalPrice()).isEqualTo(FIRST_PRICE + SECOND_PRICE + THIRD_PRICE + FORTH_PRICE + FIFTH_PRICE);
    }
}