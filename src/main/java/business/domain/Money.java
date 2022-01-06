package business.domain;

import java.util.Objects;

public class Money {

    private static final long UNIT_VALUE = 1_000L;

    private final long value;

    public Money(long value) {
        if (!isValueValid(value)) {
            throw new IllegalArgumentException(
                String.format("%d원 단위의 값만 금액으로 사용 가능합니다.", UNIT_VALUE));
        }

        this.value = value;
    }

    public static Money add(Money m1, Money m2) {
        return new Money(m1.getValue() + m2.getValue());
    }

    public static Money sub(Money m1, Money m2) {
        return new Money(m1.getValue() - m2.getValue());
    }

    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);
    }

    public LotteryCount calculateMaxLotteryCount() {
        return new LotteryCount((int) (this.value / UNIT_VALUE));
    }

    public static RateOfYield calculateRateOfYield(Money base, Money income) {
        return new RateOfYield(
            ((double) (100 * (income.getValue() - base.getValue()))) / base.getValue());
    }

    private boolean isValueValid(long value) {
        return value % UNIT_VALUE == 0;
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
