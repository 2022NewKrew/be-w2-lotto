package be.w2.lotto.common.exception;

public class PurchaseAmountLowerboundException extends RuntimeException{
    public PurchaseAmountLowerboundException() {
        super(PURCHASE_AMOUNT_LOWERBOUND_EXCEPTION);
    }

    public static final String PURCHASE_AMOUNT_LOWERBOUND_EXCEPTION = "로또 구매금액은 최소 0 이상 가능합니다.";
}
