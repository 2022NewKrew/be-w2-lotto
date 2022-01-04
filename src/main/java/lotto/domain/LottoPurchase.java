package lotto.domain;

public class LottoPurchase {

    private final int PRICE = 1000;

    private int money;

    public LottoPurchase(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int purchase() {
        return money / PRICE;
    }
}
