package lotto.constant;

/*
사용하는 상수들을 선언하여 저장하는 곳
 */
public final class Constants {
    public final static int MIN_MATCHING_NUM_TO_WINNING                             = 3;
    public final static int MAX_MATCHING_NUM_TO_WINNING                             = 7;
    public final static int NUM_OF_WINNING_NUMBERS                                  = 6;
    public final static int LOTTO_START_NUMBER                                      = 1;
    public final static int LOTTO_END_NUMBER                                        = 45;
    public final static int PRICE_OF_LOTTO                                          = 1000;

    public final static String SPLIT_DELIMITER                                      = ", ";
    public final static String NEW_LINE                                             = "\n";
    public final static String PURCHASE_MONEY_INPUT_MESSAGE                         = "구입금액을 입력해 주세요.";
    public final static String WINNING_NUMBERS_INPUT_MESSAGE                        = "지난 주 당첨 번호를 입력해 주세요.";
    public final static String BONUS_NUMBER_INPUT_MESSAGE                           = "보너스 번호를 입력해 주세요.";
    public final static String PURCHASE_MONEY_ONLY_NUMBER_ERROR_MESSAGE             = "구입 금액은 숫자만 입력 가능합니다.";
    public final static String PURCHASE_MONEY_ONLY_MULTIPLE_OF_PRICE_ERROR_MESSAGE  = String.format("[ERROR] 구입금액은 1원 이상, %d원 단위로 입력하셔야 합니다.", PRICE_OF_LOTTO);
    public final static String LOTTO_NUMBERS_INVALID_ERROR_MESSAGE                  = String.format("[ERROR] 로또번호는 %d 이상, %d 이하의 숫자 %d 개만 입력하셔야 합니다.", LOTTO_START_NUMBER, LOTTO_END_NUMBER, NUM_OF_WINNING_NUMBERS);
    public final static String WINNING_NUMBERS_NEED_6_ERROR_MESSAGE                 = String.format("[ERROR] 당첨 번호는 %d개를 입력해주셔야 합니다.", NUM_OF_WINNING_NUMBERS);
    public final static String WINNING_NUMBERS_ONLY_NUMBER_ERROR_MESSAGE            = "[ERROR] 당첨 번호와 보너스 번호는 숫자만 입력 가능합니다.";
    public final static String WINNING_NUMBERS_IN_RANGE_ERROR_MESSAGE               = String.format("[ERROR] 당첨 번호와 보너스 번호는 %d~%d의 숫자만 가능합니다.", LOTTO_START_NUMBER, LOTTO_END_NUMBER);
    public final static String PURCHASE_LOTTO_MESSAGE                               = "개를 구매했습니다.";
    public final static String RESULT_TITLE                                         = "당첨 결과";
    public final static String PARTITION                                            = "-".repeat(20);
    public final static String WINNING_MESSAGE_FORMAT                               = "%s (%d원) - %d개";
    public final static String EARNING_RATE_MSG_FORMAT                              = "총 수익률은 %.2f%% 입니다.";
    public final static String INVALID_INPUT_ERROR_MESSAGE                          = "[ERROR] 잘못된 입력입니다.";
}
