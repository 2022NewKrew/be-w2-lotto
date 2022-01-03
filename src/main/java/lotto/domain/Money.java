package lotto.domain;

public class Money {
    private final int price;

    public Money(int price) {
        if (isNegative(price)) {
            throw new IllegalArgumentException("0원 이상의 금액을 입력해주세요.");
        }
        this.price = price;
    }

    private boolean isNegative(int price) {
        return price < 0;
    }
}
