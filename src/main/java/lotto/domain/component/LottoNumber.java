package lotto.domain.component;

public class LottoNumber {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LottoNumber))
            return false;
        LottoNumber n = (LottoNumber) o;
        return n.number == number;
    }

    private void validateLottoNumber(int number) throws IllegalArgumentException {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는" + LOTTO_MIN_NUMBER + "과" + LOTTO_MAX_NUMBER + "사이로 입력해주세요.");
        }
    }
}
