package CONST;

public class Const {
    // Lottos
    public static final String BUY_COUNT_PREFIX = "수동으로 ";
    public static final String BUY_COUNT_INFIX = "장, 자동으로 ";
    public static final String BUY_COUNT_POSTFIX = "장을 구매했습니다.";

    // InputManager
    public static final String DELIMITER = ",";
    public static final String INPUT_BUY_PRICE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_INTEGER = "정수를 입력해 주세요.";
    public static final String INPUT_POSITIVE_INTEGER = "양의 정수를 입력해 주세요.";
    public static final String INPUT_SIX_DISTINCT_NUMBER = "1~45의 서로 다른 수 6개를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String INPUT_LOTTO_BONUS_NUMBER = "1~45사이의 당첨번호와 겹치지 않는 숫자를 입력해 주세요.";
    public static final String INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_ALLOWED_COUNT = "구입금액으로 살 수 있는 0이상의 숫자를 입력해주세요.";
    public static final String INPUT_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    // PrintManager
    public static final String SHOW_RESULT = "당첨 통계\n---------";
    public static final String CORRECT_THREE = "3개 일치 (5,000원)- ";
    public static final String CORRECT_FOUR = "4개 일치 (50,000원)- ";
    public static final String CORRECT_FIVE = "5개 일치 (1,500,000원)- ";
    public static final String CORRECT_FIVE_BONUS = "5개 일치, 보너스 볼 일치(30,000,000원)- ";
    public static final String CORRECT_SIX = "6개 일치 (2,000,000,000원)- ";
    public static final String WIN_RATE_PREFIX = "총 수익률은 ";
    public static final String WIN_RATE_POSTFIX = "%입니다.";

    // Lotto
    public static final int LOTTO_START_NUM = 1;
    public static final int LOTTO_END_NUM = 45;
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_SELECT_NUM = 6;
    public static final int LOTTO_THREE_WIN = 3;
    public static final int LOTTO_FOUR_WIN = 4;
    public static final int LOTTO_FIVE_WIN = 5;
    public static final int LOTTO_FIVE_BONUS_WIN = 7;
    public static final int LOTTO_SIX_WIN = 6;
    public static final int LOTTO_THREE_WIN_PRICE = 5000;
    public static final int LOTTO_FOUR_WIN_PRICE = 50000;
    public static final int LOTTO_FIVE_WIN_PRICE = 1500000;
    public static final int LOTTO_FIVE_BONUS_WIN_PRICE = 30000000;
    public static final int LOTTO_SIX_WIN_PRICE = 2000000000;
}
