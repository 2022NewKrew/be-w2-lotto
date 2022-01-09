package lotto;

import lotto.domain.Lotto;
import lotto.vo.LottoVO;
import lotto.result.LottoRank;
import lotto.view.LottoView;
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
        List<LottoVO> lottos = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
            lottos.add(new LottoVO(lotto));
        }
        LottoView.outputPurchaseResult(lottos.subList(0,5), lottos.subList(5,10));
    }

    @Test
    void outputLottoResult() {
        List<LottoVO> lottos = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
            lottos.add(new LottoVO(lotto));
        }
        List<Integer> lastWeekLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoRank> lottoRanks = LottoRank.createLottoResults(lottos, lastWeekLottoNumbers, 7);
        LottoView.outputLottoResult(lottoRanks);
    }
}