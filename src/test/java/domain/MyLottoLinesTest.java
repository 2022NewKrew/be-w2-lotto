package domain;

import DTO.NNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottoLinesTest {
    private static MyLottoLines mll;

    private static final int NUM_PER_LINE = 6;

    @BeforeEach
    void setUp() {
        mll = new MyLottoLines();
        MatchScore.initForTest();
    }

    @Test
    void getNumLotto() {
        assertThat(mll.getNumLotto()).isEqualTo(0);
    }

    @Test
    void addLotto() {
        assertThat(mll.getNumLotto()).isEqualTo(0);
        mll.addLotto(makeSampleNNumberObj());
        assertThat(mll.getNumLotto()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 10, 100, 1000})
    void checkWinning(int numLotto) {
        for (int i = 0; i < numLotto; i++) {
            mll.addLotto(makeSampleNNumberObj());
        }

        mll.checkWinning(makeSampleNNumberObj(), makeBonusNNumberObj());
        assertThat(mll.getNumLotto()).isEqualTo(numLotto);

        MatchScore firstWin = MatchScore.findMatchScoreObject(NUM_PER_LINE, 0);
        assertThat(firstWin.getNumLotto()).isEqualTo(numLotto);
    }

    private NNumber makeSampleNNumberObj() {
        java.util.List<Integer> srcList = new ArrayList<>();

        for (int i = 1; i <= NUM_PER_LINE; i++) {
            srcList.add(i);
        }

        return NNumber.makeManualNumbers(srcList);
    }

    private NNumber makeBonusNNumberObj() {
        return NNumber.makeManualNumbers(new ArrayList<>());
    }
}