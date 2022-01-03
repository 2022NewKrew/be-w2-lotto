package domain.lotto;

public class Number implements Comparable<Number>{
    private final int number;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Override
    public int compareTo(Number o) {
        return this.number - o.number;
    }

    public Number(int number) {
        isValid(number);
        this.number = number;
    }

    private void isValid(int number) {
        if(MIN_NUMBER <= number && number <= MAX_NUMBER) {
            return;
        }
        throw new IllegalArgumentException("숫자가 로또 범위를 초과하였습니다.");
    }

    public int getNumber() {
        return number;
    }

    public boolean isSame(Number targetNum) {
        return number == targetNum.getNumber();
    }

}
