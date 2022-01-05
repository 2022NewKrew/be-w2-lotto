package messages;

public enum ErrorMessage {
    NEGATIVE_PURCHASE_AMOUNT("구입금액이 음수입니다"),
    INVALID_WINNING_NUMBER("당첨 번호는 1부터 45사이어야 합니다"),
    SIX_WINNING_NUMBER("당첨 번호가 6개가 아닙니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
