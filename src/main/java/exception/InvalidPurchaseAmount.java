package exception;

public class InvalidPurchaseAmount extends RuntimeException {
    public static final String MINIMUM_PURCHASE_AMOUNT = "최소한 로또 1장 이상을 구매해야합니다.";
    public static final String MAXIMUM_PURCHASE_AMOUNT = "최대 로또 100장까지만 구매가능합니다.";

    public InvalidPurchaseAmount(String message) {
        super(message);
    }
}
