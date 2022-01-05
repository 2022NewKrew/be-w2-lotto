package domain;

import java.util.regex.Pattern;

public class LottoCount {
    private long money;
    private long manualLottoCount;
    private long autoLottoCount;
    private static final long PRICE_PER_LOTTO = 1000;
    private static final String MESSAGE_INVALID_COST = "구매 금액은 1000원 이상이어야 합니다.";
    private static final String MESSAGE_CHECK_NUMERIC = "구매 금액은 1000이상의 정수여야 합니다.";
    private static final String MESSAGE_EXCEED_AMOUNT = "구입 금액을 초과하여 수동 로또를 구입할 수 없습니다.";
    private static final String NUMERIC_REGEX = "[1-9][0-9]*$";
    private static final Pattern PATTERN_NUMERIC = Pattern.compile(NUMERIC_REGEX);

    public LottoCount(String money, long manualLottoCount) {
        this(checkNumeric(money), manualLottoCount);
    }

    public LottoCount(long money, long manualLottoCount) {
        validateMoney(money);
        this.money = money;
        validateManualLottoCount(manualLottoCount);
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = (money / PRICE_PER_LOTTO) - manualLottoCount;
    }

    private static long checkNumeric(String number) {
        if (!PATTERN_NUMERIC.matcher(number).matches()) {
            throw new IllegalArgumentException(MESSAGE_CHECK_NUMERIC);
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
