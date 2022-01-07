package exception;

public class InvalidPurchaseAmount extends RuntimeException {
    public static final String MINIMUM_PURCHASE_AMOUNT = "최소한 로또 1장 이상을 구매해야합니다.";
    public static final String MAXIMUM_PURCHASE_AMOUNT = "최대 로또 100장까지만 구매가능합니다.";
    public static final String MANUAL_COST_SHOULD_LARGER_THAN_PURCHASE_AMOUNT = "구입금액보다 수동구매로또수가 많습니다.";

    public InvalidPurchaseAmount(String message) {
        super(message);
    }
}
