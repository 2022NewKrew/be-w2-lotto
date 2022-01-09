package lotto.domain;

public class Money {

    private static final String INPUT_MONEY_ERROR_MESSAGE = "돈은 음수값을 가질 수 없습니다.";
    private static final String INCORRECT_TICKET_COUNT_MESSAGE = "티켓 개수는 음수값을 가질 수 없습니다.";
    private static final String TOO_MUCH_TICKET_COUNT_MESSAGE = "잔액이 부족합니다.";
    private static final int ZERO = 0;
    private static final int ONE_HUNDRED = 100;
    private final int money;

    public Money(int money) {
        if (money < ZERO)
            throw new IllegalArgumentException(INPUT_MONEY_ERROR_MESSAGE);
        this.money = money;
    }

    public Amount calculateTotalAmount(int ticketPrice) {
        if (ticketPrice < 1000)
            throw new IllegalArgumentException();
        return new Amount(money / ticketPrice);
    }
}
