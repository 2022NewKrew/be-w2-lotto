package domain;

import DTO.NNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class LottoLineTest {
    private LottoLine lottoLine;

    private static final int NUM_PER_LINE = 6;

    @BeforeEach
    void setUp() {
        java.util.List<Integer> srcList = new ArrayList<>();

        for (int i = 1; i <= NUM_PER_LINE; i++) {
            srcList.add(i);
        }

        lottoLine = new LottoLine(NNumber.makeManualNumbers(srcList));
    }

    @Test
    void checkWinning() {
        for (int matchNum = 0; matchNum <= NUM_PER_LINE; matchNum++) {
            NNumber curWinningLine = makeNMatchingNNumber(matchNum);

            assertThat(lottoLine.checkWinning(curWinningLine)).isEqualTo(matchNum);
        }
    }

    private NNumber makeNMatchingNNumber(int matchNum) {
        java.util.List<Integer> srcList = new ArrayList<>();

        for (int i = 1; i <= matchNum; i++) {
            srcList.add(i);
        }
        for (int i = matchNum + 1; i <= NUM_PER_LINE; i++) {
            srcList.add(NUM_PER_LINE + i);
        }

        return NNumber.makeManualNumbers(srcList);
    }
}