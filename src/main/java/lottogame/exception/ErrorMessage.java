package lottogame.exception;

public enum ErrorMessage {
    UNDER_MIN_AMOUNT("구입개수는 0보다 작을 수 없습니다."),
    UNDER_MIN_LOTTERY_NUMBER("로또번호는 1이상 입니다."),
    OVER_MAX_LOTTERY_NUMBER("로또번호는 45이하 입니다."),
    PRAMETER_IS_NULL("null일 수 없습니다."),
    NOT_MATCH_LOTTERY_NUMBERS_DEFAULT_LENGTH("로또번호는 6개 입니다."),
    DUPLICATE_LOTTERY_NUMBERS("로또번호는 중복될 수 없습니다."),
    UNDER_MIN_PRICE("금액은 0보다 커야합니다."),
    INSUFFICIENT_PRICE("구입금액이 부족합니다."),
    DUPLICATE_BONUS_BALL("당첨 번호와 보너스 볼이 중복됩니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}