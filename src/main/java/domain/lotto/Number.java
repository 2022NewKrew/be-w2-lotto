package domain.lotto;

public class Number implements Comparable<Number> {
    private final int value;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Override
    public int compareTo(Number o) {
        return this.value - o.value;
    }

    public Number(int value) {
        isValid(value);
        this.value = value;
    }

    private void isValid(int value) {
        if (MIN_NUMBER <= value && value <= MAX_NUMBER) {
            return;
        }
        throw new IllegalArgumentException("숫자가 로또 범위를 초과하였습니다.");
    }

    public int getValue() {
        return value;
    }

    public boolean isSame(Number targetNum) {
        return value == targetNum.getValue();
    }
}
