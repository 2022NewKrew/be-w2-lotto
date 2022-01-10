package domain.LottoLineStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoLineTest {
    private ManualLottoLine lottoLine;
    private static final int NUM_PER_LINE = 6;

    @BeforeEach
    void setUp() {
        java.util.List<String> srcList = new ArrayList<>();

        for (int i = 1; i <= NUM_PER_LINE; i++) {
            srcList.add(String.valueOf(i));
        }

        lottoLine = ManualLottoLine.makeManualLottoLineFromStrLst(srcList);
    }

    @Test
    void makeWinningLineBasic() {
        List<String> basic = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> reverse = Arrays.asList("6", "5", "4", "3", "2", "1");

        assertThat(ManualLottoLine.makeManualLottoLineFromStrLst(basic)).isNotNull();
        assertThat(ManualLottoLine.makeManualLottoLineFromStrLst(reverse)).isNotNull();
    }

    @Test
    void makeWinningLineParameterError() {
        List<String> tooFew = Arrays.asList("1", "2", "3", "4", "5");
        List<String> tooMany = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

        assertThat(ManualLottoLine.makeManualLottoLineFromStrLst(tooFew)).isNull();
        assertThat(ManualLottoLine.makeManualLottoLineFromStrLst(tooMany)).isNull();
    }

    @Test
    void makeWinningLineLowerBound() {
        List<String> belowLowerBound = Arrays.asList("0", "2", "3", "4", "5", "6");

        assertThat(ManualLottoLine.makeManualLottoLineFromStrLst(belowLowerBound)).isNull();
    }

    @Test
    void makeWinningLineUpperBound() {
        List<String> belowUpperBound = Arrays.asList("45", "2", "3", "4", "5", "6");
        List<String> aboveUpperBound = Arrays.asList("46", "2", "3", "4", "5", "6");

        assertThat(ManualLottoLine.makeManualLottoLineFromStrLst(belowUpperBound)).isNotNull();
        assertThat(ManualLottoLine.makeManualLottoLineFromStrLst(aboveUpperBound)).isNull();
    }

    @Test
    void makeWinningLineDuplicatedNumber() {
        List<String> allSameNum = Arrays.asList("2", "2", "2", "2", "2", "2");
        List<String> twoSameNum = Arrays.asList("2", "2", "3", "4", "5", "6");
        List<String> splitTwoSameNum = Arrays.asList("1", "5", "3", "4", "5", "6");

        assertThat(ManualLottoLine.makeManualLottoLineFromStrLst(allSameNum)).isNull();
        assertThat(ManualLottoLine.makeManualLottoLineFromStrLst(twoSameNum)).isNull();
        assertThat(ManualLottoLine.makeManualLottoLineFromStrLst(splitTwoSameNum)).isNull();
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
        List<Integer> getLine = lottoLine.getLottoLine();

        for (int i = 0; i < NUM_PER_LINE; i++) {
            assertThat(getLine.get(i)).isEqualTo(i + 1);
        }
    }

    @Test
    void getPrintLine() {
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