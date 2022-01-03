package validator;

public class ScannerValidator {
    public static final String ILLEGAL_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 1000원 단위의 숫자를 입력해 주세요.\n";

    public static void assertValidPurchaseAmount(int purchaseAmount) throws NumberFormatException  {
        if ((purchaseAmount % 1000) != 0) {
            throw new NumberFormatException(ILLEGAL_PURCHASE_AMOUNT_MESSAGE);
        }
    }
}
