package lotto.step3.model;

import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.model.Lotto;
import lotto.step1.model.LottoGenerator;
import lotto.step1.model.LottoNumbers;
import lotto.step2.model.LottoAddBonusBall;
import lotto.step2.model.LottoAddBonusBallGenerator;
import lotto.step2.model.LottoNumbersAddBonusBall;
import lotto.step3.dto.request.NonAutoLottoPurchaseSheetDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class NonAutoLottoAddBonusBallGeneratorTest {

    @Test
    @DisplayName("보너스볼과 수동 구매 기능이 추가된 로또를 정상적으로 생성하는 테스트")
    void generate() {
        // given
        final int price = 1000;
        final int purchaseAmount = 3000;

        final List<List<Integer>> nonAutoNumbersList = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7)
        );

        final LottoGenerator lottoGenerator = new NonAutoLottoAddBonusBallGenerator();
        final LottoPurchaseSheetDTO lottoPurchaseSheetDTO = new NonAutoLottoPurchaseSheetDTO(purchaseAmount, nonAutoNumbersList);

        // when
        final Lotto lotto = lottoGenerator.generate(lottoPurchaseSheetDTO);

        // then
        final int numOfLottoNumbers = purchaseAmount / price;
        final List<LottoNumbers> purchasedLottoNumbersList = lotto.getPurchasedLottoNumbersList();
        assertEquals(purchasedLottoNumbersList.size(), numOfLottoNumbers);

        final LottoNumbers actualLottoNumbers = purchasedLottoNumbersList.get(0);
        assertEquals(actualLottoNumbers.getClass(), LottoNumbersAddBonusBall.class);

        assertEquals(lotto.getClass(), LottoAddBonusBall.class);

        // 수동으로 만든거 확인
        assertEqualsNonAutoNumbersListAndPurchasedLottoNumbersList(nonAutoNumbersList, purchasedLottoNumbersList);
    }

    private void assertEqualsNonAutoNumbersListAndPurchasedLottoNumbersList(List<List<Integer>> nonAutoNumbersList, List<LottoNumbers> purchasedLottoNumbersList) {
        final int start = purchasedLottoNumbersList.size() - nonAutoNumbersList.size();
        final int end = nonAutoNumbersList.size();

        IntStream.range(start, end).forEach(index -> {
            final LottoNumbers actualNonAutoLottoNumbers1 = purchasedLottoNumbersList.get(index);
            final String nonAutoNumbersStr = nonAutoNumbersList.get(index - 1).stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            assertEquals(actualNonAutoLottoNumbers1.toNumbersListStr(), nonAutoNumbersStr);
        });
    }
}