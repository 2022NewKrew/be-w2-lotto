package lotto.constant;

public enum OutputMessage implements Message{
    OUTPUT_RANK("%d개 일치 (%d원)- %d개"),
    OUTPUT_RANK_2ND("%d개, 보너스 볼 일치 (%d원)- %d개"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
