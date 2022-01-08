package lotto.view;

import static lotto.controller.LottoSimulator.LOTTO_PRICE;

public class InputValidationChecker {

    public boolean checkPositiveNumber(long num) {
        return num < 0;
    }

    public boolean checkAmountUnit(long purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != 0;
    }
}
