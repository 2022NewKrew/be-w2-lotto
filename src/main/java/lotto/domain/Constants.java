package lotto.domain;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 4:39
 */
public class Constants {
    public static final Integer LOTTO_MIN_NUMBER = 1;
    public static final Integer LOTTO_MAX_NUMBER = 45;
    public static final Integer LOTTO_SIZE = 6;
    public static final Integer LOTTO_PRICE = 1000;

    public static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_LAST_WEEK_DELIMITER = ", ";
    public static final String INPUT_LAST_WEEK_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";

    public static final String PRINT_PURCHASE_LOTTO_FORMAT = "%d개를 구매했습니다.";
    public static final String PRINT_WINNING_STATISTICS = "\n당첨 통계\n---------";
    public static final String PRINT_MATCHED_FORMAT = "%d개 일치 (%d원) - %d개";
    public static final String PRINT_YIELD_FORMAT = "총 수익률은 %d%%입니다.";
}
