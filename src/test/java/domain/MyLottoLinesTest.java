package domain;

import domain.LottoLineStructure.ManualLottoLine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottoLinesTest {
    private final MyLottoLines mll = new MyLottoLines();
    private final MatchStore matchStore = new MatchStore();

    private static final int NUM_PER_LINE = 6;

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 10, 100, 1000})
    void checkWinning(int numLotto) {
        for (int i = 0; i < numLotto; i++) {
            mll.addLotto(makeSampleLottoLine());
        }

        mll.checkWinning(matchStore, makeSampleLottoLine().getLottoLine(), makeBonusList());

        int totalNum = 0;
        for (WinningClassifier grade : WinningClassifier.values()) {
            totalNum += matchStore.getCnt(grade);
        }
        assertThat(totalNum).isEqualTo(numLotto);

        WinningClassifier firstWin = WinningClassifier.findMatchScoreObject(NUM_PER_LINE, 0);
        assertThat(matchStore.getCnt(firstWin)).isEqualTo(numLotto);
    }

    private LottoLine makeSampleLottoLine() {
        java.util.List<String> srcList = new ArrayList<>();

        for (int i = 1; i <= NUM_PER_LINE; i++) {
            srcList.add(String.valueOf(i));
        }

        return ManualLottoLine.makeManualLottoLineFromStrLst(srcList);
    }

    private List<Integer> makeBonusList() {
        return new ArrayList<>();
    }
}