package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoLineTest {

    @Test
    void makeWinningLineBasic() {
        List<String> basic = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> reverse = Arrays.asList("6", "5", "4", "3", "2", "1");

        assertThat(WinningLottoLine.makeWinningLine(basic)).isNotNull();
        assertThat(WinningLottoLine.makeWinningLine(reverse)).isNotNull();
    }

    @Test
    void makeWinningLineParameterError() {
        List<String> tooFew = Arrays.asList("1", "2", "3", "4", "5");
        List<String> tooMany = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

        assertThat(WinningLottoLine.makeWinningLine(tooFew)).isNull();
        assertThat(WinningLottoLine.makeWinningLine(tooMany)).isNull();
    }

    @Test
    void makeWinningLineLowerBound() {
        List<String> belowLowerBound = Arrays.asList("0", "2", "3", "4", "5", "6");

        assertThat(WinningLottoLine.makeWinningLine(belowLowerBound)).isNull();
    }

    @Test
    void makeWinningLineUpperBound() {
        List<String> belowUpperBound = Arrays.asList("45", "2", "3", "4", "5", "6");
        List<String> aboveUpperBound = Arrays.asList("46", "2", "3", "4", "5", "6");

        assertThat(WinningLottoLine.makeWinningLine(belowUpperBound)).isNotNull();
        assertThat(WinningLottoLine.makeWinningLine(aboveUpperBound)).isNull();
    }

    @Test
    void makeWinningLineDuplicatedNumber() {
        List<String> allSameNum = Arrays.asList("2", "2", "2", "2", "2", "2");
        List<String> twoSameNum = Arrays.asList("2", "2", "3", "4", "5", "6");
        List<String> splitTwoSameNum = Arrays.asList("1", "5", "3", "4", "5", "6");

        assertThat(WinningLottoLine.makeWinningLine(allSameNum)).isNull();
        assertThat(WinningLottoLine.makeWinningLine(twoSameNum)).isNull();
        assertThat(WinningLottoLine.makeWinningLine(splitTwoSameNum)).isNull();
    }

    @Test
    void setBonus() {
        List<String> basic = Arrays.asList("1", "2", "3", "4", "5", "6");

        WinningLottoLine wll = WinningLottoLine.makeWinningLine(basic);

        assertThat(wll.setBonus(0)).isEqualTo(false);
        assertThat(wll.setBonus(46)).isEqualTo(false);
        assertThat(wll.setBonus(3)).isEqualTo(false);
        assertThat(wll.setBonus(12)).isEqualTo(true);
        assertThat(wll.setBonus(39)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 10, 22, 38, 42, 45})
    void getBonus(int bonusNum) {
        List<String> basic = Arrays.asList("1", "2", "3", "4", "5", "6");

        WinningLottoLine wll = WinningLottoLine.makeWinningLine(basic);
        wll.setBonus(bonusNum);
        assertThat(wll.getBonus()).isEqualTo(bonusNum);
    }

    @Test
    void getLottoLine() {
        List<String> basic = Arrays.asList("5", "4", "6", "3", "1", "2");

        WinningLottoLine wll = WinningLottoLine.makeWinningLine(basic);
        assertThat(wll).isNotNull();
        List<Integer> lottoLine = wll.getLottoLine();

        for (int i = 0; i < 6; i++) {
            assertThat(lottoLine.get(i)).isEqualTo(i + 1);
        }
    }
}