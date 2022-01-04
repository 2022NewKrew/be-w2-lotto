package lotto.domain.constant;

public enum LottoMessage {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_MONEY_SUCCESS("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    NUMBER_OUT_OF_BOUND_ERROR("1 이상 45 이하의 값을 입력해 주세요."),
    NUMBER_DUPLECATED_ERROR("중복된 입력 값이 존재합니다."),
    INPUT_BONUS_NUMBER("보너스 볼을 입력해 주세요."),
    PARSING_ERROR("숫자 값만 입력할 수 있습니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
