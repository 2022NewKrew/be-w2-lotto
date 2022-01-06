package bin.jaden.be_w2_lotto.domain;

public class Constants {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int NUMBERS_PER_GAME = 6;
    public static final int PRICE_PER_GAME = 1000;

    public static final String INPUT_PURCHASING_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WRONG_PURCHASING_AMOUNT_MESSAGE = "구매금액은 숫자로 입력해주세요.";
    public static final String INVALID_PURCHASING_AMOUNT_MESSAGE = String.format("구매금액은 %d원 이상이여야 합니다.", Constants.PRICE_PER_GAME);

    public static final String INPUT_NUMBER_OF_PURCHASE_MANUALLY_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_WRONG_NUMBER_OF_PURCHASE_MANUALLY_MESSAGE = "수동 구매 개수는 숫자로 입력해주세요.";
    public static final String INVALID_NUMBER_OF_PURCHASE_MANUALLY_MESSAGE = "수동 구매 개수는 음수일 수 없습니다.";
    public static final String INVALID_NUMBER_OF_PURCHASE_MANUALLY_RANGE_MESSAGE = "구매금액보다 많은 로또를 수동 구매할 수 없습니다.";

    public static final String INPUT_MANUAL_NUMBERS_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";
    public static final String INPUT_MANUAL_NUMBERS_DELIMITER = ",";
    public static final String INPUT_WRONG_MANUAL_NUMBERS_MESSAGE = "수동 번호는 숫자로 입력해주세요.";
    public static final String INVALID_MANUAL_NUMBERS_RANGE_MESSAGE = String.format("수동 번호중에 로또의 범위를 넘어가는 숫자가 있습니다. (최소 : %d, 최대 : %d)", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    public static final String INVALID_MANUAL_NUMBERS_LENGTH_MESSAGE = "수동 번호의 사이즈가 올바르지 않습니다.";
    public static final String DUPLICATE_MANUAL_NUMBERS_MESSAGE = "중복된 수동 번호가 있습니다.";

    public static final String INPUT_WIN_NUMBERS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_WIN_NUMBERS_DELIMITER = ",";
    public static final String INPUT_WRONG_WIN_NUMBERS_MESSAGE = "당첨번호는 숫자로 입력해주세요.";
    public static final String INVALID_WIN_NUMBERS_RANGE_MESSAGE = String.format("당첨번호중에 로또의 범위를 넘어가는 숫자가 있습니다. (최소 : %d, 최대 : %d)", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    public static final String INVALID_WIN_NUMBERS_LENGTH_MESSAGE = "당첨번호의 사이즈가 올바르지 않습니다.";
    public static final String DUPLICATE_WIN_NUMBERS_MESSAGE = "중복된 당첨번호가 있습니다.";

    public static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String INVALID_BONUS_NUMBER_MESSAGE = "보너스 볼은 숫자로 입력해주세요.";
    public static final String INVALID_BONUS_NUMBER_RANGE_MESSAGE = String.format("보너스 볼의 값이 로또의 범위를 넘었습니다. (최소 : %d, 최대 : %d)", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    public static final String DUPLICATE_BONUS_NUMBERS_MESSAGE = "보너스 볼이 당첨번호와 중복되었습니다.";

    public static final String PRINT_LOTTO_GAMES_SIZE_FORMAT = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    public static final String PRINT_RESULT_TITLE = "\n당첨통계\n---------";
    public static final String PRINT_RESULT_FORMAT = "%d개 일치 (%d원)- %d개";
    public static final String PRINT_2ND_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    public static final String PRINT_TOTAL_REWARD_RATIO_FORMAT = "총 수익률은 %d%%입니다.\n";
}
