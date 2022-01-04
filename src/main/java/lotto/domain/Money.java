package lotto.domain;

public class Money {
    private final long price;

    public Money(long price) {
        if (isNegative(price)) {
            throw new IllegalArgumentException("0원 이상의 금액을 입력해주세요.");
        }
        this.price = price;
    }

    private boolean isNegative(long price) {
        return price < 0;
    }

    public int getRevenueRate(Money inputMoney) {
        double revenueRate = (double) this.price / inputMoney.price;
        return (int) Math.round(revenueRate * 100);
    }

    public int getNumberOfTickets(int ticketPrice) {
        return (int) (price / ticketPrice);
    }
}
