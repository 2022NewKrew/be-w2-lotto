package lotto.step2.model;

import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.model.Lotto;
import lotto.step1.model.LottoGenerator;
import lotto.step1.model.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoAddBonusBallGeneratorTest {

    @Test
    @DisplayName("보너스볼이 추가된 로또를 정상적으로 생성하는 테스트")
    void generate() {
        // given
        final int price = 1000;
        final int purchaseAmount = 3000;

        final LottoGenerator lottoGenerator = new LottoAddBonusBallGenerator();
        final LottoPurchaseSheetDTO lottoPurchaseSheetDTO = new LottoPurchaseSheetDTO(purchaseAmount);

        // when
        final Lotto lotto = lottoGenerator.generate(lottoPurchaseSheetDTO);

        // then
        assertEquals(lotto.getPurchasedLottoNumbersList().size(), purchaseAmount / price);

        final LottoNumbers actualLottoNumbers = lotto.getPurchasedLottoNumbersList().get(0);
        assertEquals(actualLottoNumbers.getClass(), LottoNumbersAddBonusBall.class);

        assertEquals(lotto.getClass(), LottoAddBonusBall.class);
    }
}