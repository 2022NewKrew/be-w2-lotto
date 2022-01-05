package lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoViewTest {

    @Test
    void inputPurchaseAmount() {
        assertEquals(14, LottoView.inputPurchaseAmount(new ByteArrayInputStream("14000\n".getBytes())));
    }

    @Test
    void inputLastWeekLottoNumbers() {
        List<Integer> lastWeekLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(lastWeekLottoNumbers.size(), LottoView.inputLastWeekLottoNumbers(new ByteArrayInputStream("1, 2, 3, 4, 5, 6 ".getBytes())).size());
    }

    @Test
    void outputPurchaseResult() {
        LottoView lottoView = new LottoView();
        List<LottoDto> lottos = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Lotto lotto = new Lotto();
            lotto.generateNumbers();
            lottos.add(new LottoDto(lotto));
        }
        lottoView.outputPurchaseResult(lottos);
    }

    @Test
    void outputLottoResult() {
        List<LottoDto> lottos = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Lotto lotto = new Lotto();
            lotto.generateNumbers();
            lottos.add(new LottoDto(lotto));
        }
        List<Integer> lastWeekLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoResult> lottoResults = LottoResult.createLottoResults(lottos, lastWeekLottoNumbers, 7);
        LottoView.outputLottoResult(lottoResults);
    }
}