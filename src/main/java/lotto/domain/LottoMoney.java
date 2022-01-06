package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class LottoMoney {

    private static final long PRICE = 1000;
    private static final int DEFAULT_SCALE = 4;
    private static final BigDecimal ORIGINAL_PROFIT = BigDecimal.valueOf(100.0);

    private long money;

    public LottoMoney(long money) {
        validate(money);
        this.money = money - money % PRICE;
    }

    private void validate(long money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("[ERROR] 최소 1,000원 이상 구매해주세요.");
        }
    }

    public int purchase() {
        return (int) (money / PRICE);
    }

    public BigDecimal profit(BigDecimal totalMoney) {
        validateTotalMoney(totalMoney);
        return totalMoney.divide(BigDecimal.valueOf(money), DEFAULT_SCALE, RoundingMode.HALF_UP)
            .multiply(ORIGINAL_PROFIT)
            .subtract(ORIGINAL_PROFIT);
    }

    private void validateTotalMoney(BigDecimal totalMoney) {
        if (Objects.isNull(totalMoney)) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }
}
