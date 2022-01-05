package domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    public LottoNumber(int number) {
        this.number = validationIntNumber(number);
    }

    public LottoNumber(String number) {
        this.number = validationStringNumber(number);
    }

    public int getNumber() {
        return number;
    }

    private int validationIntNumber(int number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException("로또 번호의 범위가 1~45가 아닙니다.");
        }
        return number;
    }

    private int validationStringNumber(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("로또 번호가 숫자가 아닙니다.");
        }
        return validationIntNumber(Integer.valueOf(number));
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.getNumber());
    }

    @Override
    public boolean equals(Object other) {
        return this.number == ((LottoNumber) other).getNumber();
    }
}
