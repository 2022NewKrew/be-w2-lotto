package lottoStage2.domain.vo;

import lottoStage2.util.RandomUtils;

import java.util.Objects;

public class Number {
    private final int number;

    private Number() {
        number = RandomUtils.nextInt();
    }

    private Number(String number) {
        this.number = Integer.parseInt(number);
    }

    private Number(int number) { this.number = number; }

    public static Number create() {
        return new Number();
    }

    public static Number of(String number) {
        return new Number(number);
    }

    public static Number of(int number) { return new Number(number); }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
