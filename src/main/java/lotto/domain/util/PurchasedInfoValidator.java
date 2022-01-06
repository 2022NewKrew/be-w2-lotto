package lotto.domain.util;

import static lotto.domain.LottoInfo.PRICE_OF_LOTTO;

public class PurchasedInfoValidator {
    public void validatePurchasedInfoInput(int purchasePrice, int countOfManualLotto) {
        validatePurchasePrice(purchasePrice);
        validateCountOfManualLotto(purchasePrice, countOfManualLotto);
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < PRICE_OF_LOTTO.getValue()) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다.");
        }
    }

    private void validateCountOfManualLotto(int purchasePrice, int countOfManualLotto) {
        if (purchasePrice / PRICE_OF_LOTTO.getValue() < countOfManualLotto) {
            throw new IllegalArgumentException("입력한 수의 로또를 구매할 수 없습니다.");
        }
    }
}