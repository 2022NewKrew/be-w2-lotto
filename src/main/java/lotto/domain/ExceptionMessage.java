package lotto.domain;

public enum ExceptionMessage {
    ERROR_INVALID_SIZE("로또의 숫자는 총 6개입니다."),
    ERROR_INVALID_NUMBER("로또의 번호는 1 ~ 45 사이의 숫자를 입력해야합니다."),
    ERROR_INVALID_PRICE("금액은 1000원 이상 입력하셔야 합니다."),
    ERROR_DUPLICATE_NUMBER("로또의 번호는 중복될 수 없습니다."),
    ERROR_DUPLICATE_BONUS_BALL("보너스 볼은 로또의 번호와 중복될 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
