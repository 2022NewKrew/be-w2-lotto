package validator;

import domain.Lotto;

public class LottoValidator {
    public static final String ILLEGAL_PURCHASE_AMOUNT_MESSAGE = "[ERROR] " + Lotto.PRICE + "원 단위의 숫자를 입력해 주세요.\n";

    public static void assertValidPurchaseAmount(int purchaseAmount) throws NumberFormatException  {
        if ((purchaseAmount % Lotto.PRICE) != 0) {
            throw new NumberFormatException(ILLEGAL_PURCHASE_AMOUNT_MESSAGE);
        }
    }
}
