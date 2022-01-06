package lotto.domain;

public class TicketNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String OUT_OF_BOUND_MESSAGE = "1~45 사이의 범위를 벗어났습니다.";

    private final int number;

    public TicketNumber(int number) {
        checkNumberScope(number);
        this.number = number;
    }

    private void checkNumberScope(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER)
            throw new IllegalArgumentException(OUT_OF_BOUND_MESSAGE);
    }

    @Override
    public boolean equals(Object ticketNumber) {
        TicketNumber compareNumber = (TicketNumber) ticketNumber;
        return compareNumber.number == this.number;
    }

    // UI 전용
    public int getNumber() {
        return number;
    }
}
