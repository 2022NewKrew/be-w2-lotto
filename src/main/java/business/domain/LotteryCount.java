package business.domain;

import java.util.Objects;

public class LotteryCount {

    private final int value;

    public LotteryCount(int value) {
        if (!isValueValid(value)) {
            throw new IllegalArgumentException("로또 발행 수량은 양수만 사용 가능합니다.");
        }
        this.value = value;
    }

    public static LotteryCount sub(LotteryCount c1, LotteryCount c2) {
        return new LotteryCount(c1.getValue() - c2.getValue());
    }

    private boolean isValueValid(int value) {
        return value >= 0;
    }

    public int getValue() {
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
        LotteryCount that = (LotteryCount) o;
        return value == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LotteryCount{" + "value=" + value + '}';
    }
}
