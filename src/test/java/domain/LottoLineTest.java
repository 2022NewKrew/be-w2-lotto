package domain;

import domain.LottoLineStructure.ManualLottoLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoLineTest {
    private ManualLottoLine lottoLine;

    private static final int NUM_PER_LINE = 6;

    @BeforeEach
    void setUp() {
        java.util.List<Integer> srcList = new ArrayList<>();

        for (int i = 1; i <= NUM_PER_LINE; i++) {
            srcList.add(i);
        }

        lottoLine = new ManualLottoLine(srcList);
    }

    @Test
    void checkWinning() {
        for (int matchNum = 0; matchNum <= NUM_PER_LINE; matchNum++) {
            List<Integer> curWinningLine = makeNMatchingList(matchNum);

            assertThat(lottoLine.checkWinning(curWinningLine)).isEqualTo(matchNum);
        }
    }

    private List<Integer> makeNMatchingList(int matchNum) {
        java.util.List<Integer> srcList = new ArrayList<>();

        for (int i = 1; i <= matchNum; i++) {
            srcList.add(i);
        }
        for (int i = matchNum + 1; i <= NUM_PER_LINE; i++) {
            srcList.add(NUM_PER_LINE + i);
        }

        return srcList;
    }
}