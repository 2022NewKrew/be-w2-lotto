package lotto.domain.lotto;

public class Money {

    private final int money;
    private static final int LOTTO_PRICE = 1000;

    public Money(int money) {
        validMoneyAmount(money);
        this.money = money;
    }

    private void validMoneyAmount(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액이 1000원을 넘어야 합니다");
        }
    }

    public int howManyAutoLottoBuy(int manualLottoCount) {
        return (money / LOTTO_PRICE) - manualLottoCount;
    }
}
