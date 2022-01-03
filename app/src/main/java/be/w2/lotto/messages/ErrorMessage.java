package be.w2.lotto.messages;

public final class ErrorMessage {

    private ErrorMessage() {
    }

    public static final String PURCHASE_AMOUNT_SHOULD_BE_POSITIVE = "구매 금액은 0 이상이여야 합니다.";
    public static final String REWARD_FOR_CORRECT_NOT_FOUNDED = "해당 개수에 대한 금액을 찾을 수 없습니다.";
}
