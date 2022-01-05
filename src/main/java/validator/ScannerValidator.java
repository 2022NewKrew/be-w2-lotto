package validator;

import domain.Lotto;

public class ScannerValidator {
    public static final String ILLEGAL_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 1000원 단위의 숫자를 입력해 주세요.\n";
    public static final String ILLEGAL_LOTTO_NUMBERS_MESSAGE = "[ERROR] 1~45 사이의 서로 다른 숫자를 입력해 주세요.\n";

    public static void assertValidPurchaseAmount(int purchaseAmount) throws NumberFormatException  {
        if ((purchaseAmount % Lotto.PRICE) != 0) {
            throw new NumberFormatException(ILLEGAL_PURCHASE_AMOUNT_MESSAGE);
        }
    }
}
