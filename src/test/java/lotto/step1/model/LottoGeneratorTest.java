package lotto.step1.model;

import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또 번호 3개를 가지는 로또를 정상적으로 생성하는 테스트")
    void generate() {
        // given
        final int price = 1000;
        final int purchaseAmount = 3000;

        final LottoGenerator lottoGenerator = new LottoGenerator();
        final LottoPurchaseSheetDTO lottoPurchaseSheetDTO = new LottoPurchaseSheetDTO(purchaseAmount);

        // when
        final Lotto lotto = lottoGenerator.generate(lottoPurchaseSheetDTO);

        // then
        assertEquals(lotto.getPurchasedLottoNumbersList().size(), purchaseAmount / price);
    }
}