package lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoViewTest {

    @Test
    void inputPurchaseAmount() {
        LottoView lottoView = new LottoView();
        assertEquals(14, lottoView.inputPurchaseAmount(new ByteArrayInputStream("14000\n".getBytes())));
    }

    @Test
    void inputLastWeekLottoNumbers() {
        LottoView lottoView = new LottoView();
        List<Integer> lastWeekLottoNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(lastWeekLottoNumbers, lottoView.inputLastWeekLottoNumbers(new ByteArrayInputStream("1, 2, 3, 4, 5, 6\n".getBytes())));
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
        LottoView lottoView = new LottoView();
        List<LottoDto> lottos = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Lotto lotto = new Lotto();
            lotto.generateNumbers();
            lottos.add(new LottoDto(lotto));
        }
        List<Integer> lastWeekLottoNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoResult> lottoResults = LottoResult.calLottoResults(lottos, lastWeekLottoNumbers);
        lottoView.outputLottoResult(lottoResults);
    }
}