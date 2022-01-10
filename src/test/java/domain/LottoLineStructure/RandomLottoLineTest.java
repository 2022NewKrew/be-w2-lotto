package domain.LottoLineStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoLineTest {
    private RandomLottoLine lottoLine;
    private List<Integer> getLine;
    private static final int NUM_PER_LINE = 6;

    @BeforeEach
    void setUp() {
        lottoLine = new RandomLottoLine();
        getLine = lottoLine.getLottoLine();
    }

    @Test
    void checkWinning() {
        for (int matchNum = 0; matchNum <= NUM_PER_LINE; matchNum++) {
            List<Integer> curWinningLine = makeNMatchingList(matchNum);

            assertThat(lottoLine.checkWinning(curWinningLine)).isEqualTo(matchNum);
        }
    }

    @Test
    void getLottoLine() {
        Set<Integer> contained = new HashSet<>();

        for (int x : getLine) {
            assertThat(x).isLessThanOrEqualTo(45);
            assertThat(x).isGreaterThanOrEqualTo(0);
            assertThat(contained.contains(x)).isFalse();

            contained.add(x);
        }
    }

    @Test
    void getPrintLine() {
    }

    private List<Integer> makeNMatchingList(int matchNum) {
        java.util.List<Integer> srcList = new ArrayList<>();

        for (int i = 1; i <= matchNum; i++) {
            srcList.add(getLine.get(i));
        }
        for (int i = matchNum + 1; i <= NUM_PER_LINE; i++) {
            srcList.add(i * -1);
        }

        return srcList;
    }
}