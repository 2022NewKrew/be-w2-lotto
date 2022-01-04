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
        assertEquals(14, LottoView.inputPurchaseAmount(new ByteArrayInputStream("14000\n".getBytes())));
    }

    @Test
    void inputLastWeekLottoNumbers() {
        LottoView lottoView = new LottoView();
        List<Integer> lastWeekLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(lastWeekLottoNumbers, LottoView.inputLastWeekLottoNumbers(new ByteArrayInputStream("1, 2, 3, 4, 5, 6\n".getBytes())));
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
        List<Long> lastWeekLottoNumbers = new ArrayList<>(Arrays.asList((long)1, (long)2, (long)3, (long)4, (long)5, (long)6));
        List<LottoResult> lottoResults = LottoResult.calLottoResults(lottos, lastWeekLottoNumbers, 7);
        LottoView.outputLottoResult(lottoResults);
    }
}