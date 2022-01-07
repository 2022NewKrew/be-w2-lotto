package lotto.constant;

public enum ExceptionMessage implements Message{
    INVALID_CREATE_LOTTO_SIZE("생성된 로또의 개수는 %d개여야 합니다."),
    INVALID_NUMBER_BOUND("%d ~ %d 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBERS("중복된 숫자가 존재 합니다.")
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
