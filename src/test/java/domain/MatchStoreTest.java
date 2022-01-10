package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchStoreTest {
    private MatchStore matchStore;

    private static final int LOTTO_FEE = 1000;

    @BeforeEach
    void SetUp() {
        matchStore = new MatchStore();
    }

    @Test
    void addAndCheckCnt() {
        WinningClassifier[] gradeArr = WinningClassifier.values();

        for (WinningClassifier grade : gradeArr) {
            assertThat(matchStore.getCnt(grade)).isEqualTo(0);

            matchStore.addMatchResult(grade.getMatchNums(), grade.isMatchBonus() ? 1 : 0);
            assertThat(matchStore.getCnt(grade)).isEqualTo(1);
        }
    }

    @Test
    void getYield() {
        float expectedYield = 0;
        long totalPrice = 0;
        int i = 0;
        assertThat(matchStore.getYield()).isEqualTo(expectedYield);

        for (WinningClassifier grade : WinningClassifier.values()) {
            matchStore.addMatchResult(grade.getMatchNums(), grade.isMatchBonus() ? 1 : 0);
            totalPrice += grade.getPrice();
            i += 1;
            expectedYield = (totalPrice / (float) i / LOTTO_FEE) * 100 - 100;
            assertThat(matchStore.getYield()).isEqualTo(expectedYield);
        }
    }
}