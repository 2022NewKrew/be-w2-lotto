package lotto.domain.model;

public class LottoNumber implements Comparable {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;

    private static final String INVALID_ERROR_MESSAGE = "로또 번호는 (1 ~ 45) 범위 내의 값을 가져야 합니다.";

    private final int number;

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    private LottoNumber(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException(INVALID_ERROR_MESSAGE);
        }
        this.number = number;
    }

    private boolean isValidNumber(int number) {
        return number >= LOWER_BOUND && number <= UPPER_BOUND;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.number, ((LottoNumber) o).number);
    }

    @Override
    public boolean equals(Object obj) {
        return number == ((LottoNumber) obj).number;
    }
}
