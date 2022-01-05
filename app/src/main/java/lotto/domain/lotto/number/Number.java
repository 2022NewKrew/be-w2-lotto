package lotto.domain.lotto.number;

public class Number {

    private final int num;

    public Number(int num) {
        validNumRange(num);
        this.num = num;
    }

    private void validNumRange(int num) {
        if(num < 1 || num > 45) {
            throw new IllegalArgumentException();
        }
    }

    public boolean numberIsIncluded(Number num) {
        return this.equals(num);
    }

    @Override
    public boolean equals(Object obj) {
        Number number = (Number) obj;
        return number.num == this.num;
    }
}
