package enums;

public enum LottoConstants {
    NUMBER_OF_LOTTERY_NUMBERS(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final int number;

    LottoConstants(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }
}
