package messages;

public enum GameMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_LAST_WEEK_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---------");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
