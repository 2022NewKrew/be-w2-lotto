package domain;

import java.util.regex.Pattern;

public class LottoCount {
    private static final long PRICE_PER_LOTTO = 1000;
    private static final String MESSAGE_CHECK_MONEY_NUMERIC = "구매 금액은 1000이상의 정수여야 합니다.";
    private static final String MESSAGE_CHECK_LOTTO_COUNT_NUMERIC = "구매할 로또 수는 0이상의 정수여야 합니다.";
    private static final String MESSAGE_INVALID_COST = "구매 금액은 1000원 이상이어야 합니다.";
    private static final String MESSAGE_EXCEED_AMOUNT = "구입 금액을 초과하여 수동 로또를 구입할 수 없습니다.";
    private static final String NUMERIC_MONEY_REGEX = "[1-9][0-9]*$";
    private static final Pattern PATTERN_MONEY_NUMERIC = Pattern.compile(NUMERIC_MONEY_REGEX);
    private static final String NUMERIC_LOTTO_COUNT_REGEX = "^[0-9]+$";
    private static final Pattern PATTERN_LOTTO_COUNT_NUMERIC = Pattern.compile(NUMERIC_LOTTO_COUNT_REGEX);
    private long money;
    private long manualLottoCount;
    private long autoLottoCount;

    public LottoCount(String money, String manualLottoCount) {
        this(checkMoneyNumeric(money), checkLottoCountNumeric(manualLottoCount));
    }

    public LottoCount(long money, long manualLottoCount) {
        validateMoney(money);
        this.money = money;
        validateManualLottoCount(manualLottoCount);
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = (money / PRICE_PER_LOTTO) - manualLottoCount;
    }

    private static long checkMoneyNumeric(String number) {
        if (!PATTERN_MONEY_NUMERIC.matcher(number).matches()) {
            throw new IllegalArgumentException(MESSAGE_CHECK_MONEY_NUMERIC);
        }
        return Integer.parseInt(number);
    }

    private static long checkLottoCountNumeric(String number) {
        if (!PATTERN_LOTTO_COUNT_NUMERIC.matcher(number).matches()) {
            throw new IllegalArgumentException(MESSAGE_CHECK_LOTTO_COUNT_NUMERIC);
        }
        return Integer.parseInt(number);
    }

    private void validateMoney(long money) {
        if (money < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(MESSAGE_INVALID_COST);
        }
    }

    private void validateManualLottoCount(long manualLottoCount) {
        if (money < manualLottoCount * PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(MESSAGE_EXCEED_AMOUNT);
        }
    }

    public long manualLottoCount() {
        return manualLottoCount;
    }

    public long autoLottoCount() {
        return autoLottoCount;
    }
}
