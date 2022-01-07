package business.domain;

import java.util.Objects;

public class Money {

    private static final long UNIT_VALUE = 1_000L;
    private static final long MONEY_MAX = Integer.MAX_VALUE * UNIT_VALUE;
    private static final long MONEY_MIN = -Integer.MAX_VALUE * UNIT_VALUE;

    private final long value;

    public Money(long value) {
        if (!isValueValid(value)) {
            throw new IllegalArgumentException(
                String.format("%,d원 이상, %,d원 이하, %,d원 단위의 값만 금액으로 사용 가능합니다.", MONEY_MIN, MONEY_MAX,
                    UNIT_VALUE));
        }

        this.value = value;
    }

    public static Money add(Money m1, Money m2) {
        return new Money(m1.getValue() + m2.getValue());
    }

    private boolean isValueValid(long value) {
        return value % UNIT_VALUE == 0 && value >= MONEY_MIN && value <= MONEY_MAX;
    }

    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);
    }

    public LotteryCount calculateMaxLotteryCount() {
        return new LotteryCount((int) (this.value / UNIT_VALUE));
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money that = (Money) o;
        return value == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
