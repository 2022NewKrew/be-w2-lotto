package validation;

import static utils.Symbol.*;

public class Validator {


    public void isValidMoney(int purchaseAmount) {
        if (!(purchaseAmount > 0 && purchaseAmount % LOTTO_PRICE == 0)) {
            throw new IllegalArgumentException(INVALID_MONEY_MESSAGE);
        }
    }

    public void isValidMannualCount(int purchaseAmount, int manualLottoCount) {
        if (purchaseAmount / LOTTO_PRICE < manualLottoCount) {
            throw new IllegalArgumentException(INVALID_MANUAL_LOTTOCOUNT);
        }
    }
}
