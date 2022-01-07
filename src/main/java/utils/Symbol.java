package utils;

public class Symbol {
    private Symbol() {
        throw new IllegalStateException("Utility class");
    }

    public static final int MIN_LOTTO_RANGE = 1;
    public static final int MAX_LOTTO_RANGE = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;
    public static final String COMMA = ",";
    public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String LAST_WEEK_WINNING_NUMBER_MESSAGE = "\"지난 주 당첨 번호를 입력해 주세요.\"";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String REWARD_MESSAGE = "당첨 통계";
    public static final String INVALID_NUMBER_RANGE = "로또 숫자의 범위 에러(숫자의 범위는 1~45)";
    public static final String INVALID_MONEY_MESSAGE = "구입 금액은 1000원 단위의 양수여야 합니다.";
    public static final String INVALID_MANUAL_LOTTOCOUNT = "수동으로 구매하는 로또 수는 전체 로또 수를 초과할 수 없습니다.";
    public static final String INPUT_FORMAT_EXCEPTION = "입력 포맷을 다시 확인해주세요";
    public static final String INVALID_LOTTO_FORMAT = "로또 구성 숫자 개수 오류(로또는 서로 중복되지 않은 6자리 숫자입니다)";
    public static final String INVALID_DUPLICATION_BONUSNUM = "보너스 번호가 기존의 로또 번호와 중복되는 숫자입니다.";
}
