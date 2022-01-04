package view;

public enum Sentence {
    PURCHASE_AMOUNT_REQUEST("구입금액을 입력해 주세요"),
    LAST_WEEK_WINNING_NUMBER_REQUEST("지난 주 당첨 번호를 입력해 주세요."),
    BONUS_BALL_REQUEST("보너스 볼을 입력해 주세요."),

    INPUT_ERROR("잘못 입력하셨습니다."),
    PLEASE_INPUT_NUMBERS("숫자만 입력해 주세요."),
    PLEASE_INPUT_POSITIVE_NUMBER("양의 정수만 입력해 주세요."),
    PLEASE_INPUT_WITHIN_LOTTO_NUMBER("로또 번호 내에서 입력해 주세요."),

    ERROR_INAPPROPRIATE_LOTTO_NUMBER("ERROR : 적절하지 않은 로또 번호"),

    COMMA(","),
    NEWLINE(System.lineSeparator()),
    ;

    private final String sentence;

    Sentence (String sentence) {
        this.sentence = sentence;
    }

    public String getString() {
        return sentence;
    }
}
