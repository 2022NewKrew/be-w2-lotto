package domain;

public class Ball {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final String ILLEGAL_NUMBERS_MESSAGE = "[ERROR] 1~45 사이의 서로 다른 숫자를 입력해 주세요.\n";
    private final int number;

    public Ball(int number) {
        assertValidNumber(number);
        this.number = number;
    }

    private void assertValidNumber(int number) throws IllegalArgumentException {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ILLEGAL_NUMBERS_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }
}
