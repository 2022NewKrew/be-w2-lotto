package domain;

public class LottoNumber {
    private final static String NUMBER_RANGE_ERROR_MESSAGE = "로또번호는 1이상 45이하이어야 합니다.";

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }
}
