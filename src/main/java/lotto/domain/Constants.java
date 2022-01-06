package lotto.domain;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 4:39
 */
public class Constants {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;

    public static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_DELIMITER = ", *";
    public static final String INPUT_LAST_WEEK_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";

    public static final String PRINT_PURCHASE_LOTTO_FORMAT = "\n수동으로 %d장, 자동으로 %d장을 구매했습니다.";
    public static final String PRINT_WINNING_STATISTICS = "\n당첨 통계\n---------";
    public static final String PRINT_MATCHED_FORMAT = "%s (%d원) - %d개";
    public static final String PRINT_YIELD_FORMAT = "총 수익률은 %.2f%%입니다.";

    public static final String PRINT_FIFTH = "3개 일치";
    public static final String PRINT_FOURTH = "4개 일치";
    public static final String PRINT_THIRD = "5개 일치";
    public static final String PRINT_SECOND = "5개 일치, 보너스 볼 일치";
    public static final String PRINT_FIRST = "6개 일치";
}
