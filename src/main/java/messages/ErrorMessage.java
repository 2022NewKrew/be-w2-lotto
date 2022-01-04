package messages;

public enum ErrorMessage {
    NEGATIVE_PURCHASE_AMOUNT("구입금액이 음수입니다"),
    NEGATIVE_WINNING_NUMBER("당첨 번호가 음수입니다"),
    EMPTY_WINNING_NUMBER("당첨 번호가 존재하지 않습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
