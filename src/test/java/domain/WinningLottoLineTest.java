package domain;

import domain.LottoLineStructure.ManualLottoLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoLineTest {
    public WinningLottoLine winningLottoLine;

    @BeforeEach
    void SetUp() {
        List<String> basic = Arrays.asList("1", "2", "3", "4", "5", "6");

        winningLottoLine = new WinningLottoLine(ManualLottoLine.makeManualLottoLineFromStrLst(basic));
    }

    @Test
    void setBonus() {
        assert winningLottoLine != null;
        assertThat(winningLottoLine.setBonus(0)).isEqualTo(false);
        assertThat(winningLottoLine.setBonus(46)).isEqualTo(false);
        assertThat(winningLottoLine.setBonus(3)).isEqualTo(false);
        assertThat(winningLottoLine.setBonus(12)).isEqualTo(true);
        assertThat(winningLottoLine.setBonus(39)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 10, 22, 38, 42, 45})
    void getBonus(int bonusNum) {
        winningLottoLine.setBonus(bonusNum);
        List<Integer> bonusList = winningLottoLine.getBonusList();
        assertThat(bonusList.size()).isEqualTo(1);
        assertThat(bonusList.get(0)).isEqualTo(bonusNum);
    }

    @Test
    void getLottoLine() {
        List<Integer> lottoLine = winningLottoLine.getLottoLine();

        for (int i = 0; i < 6; i++) {
            assertThat(lottoLine.get(i)).isEqualTo(i + 1);
        }
    }
}