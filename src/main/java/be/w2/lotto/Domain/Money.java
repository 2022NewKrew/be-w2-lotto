package be.w2.lotto.Domain;

public class Money {

    private int money;

    public Money(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("돈은 1000원 이상 입력받아야합니다!");
        }
        this.money = money;
    }

    public Money sub(int amount, int price) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("구입 갯수는 음수가 될 수 없습니다!");
        }
        if (price < 0) {
            throw new IllegalArgumentException("가격은 음수가 될 수 없습니다!");
        }
        return sub(amount * price);
    }

    public Money sub(int price) throws IllegalArgumentException {
        if (price > money) {
            throw new IllegalArgumentException("돈이 부족합니다!");
        }
        return new Money(money - price);
    }

    public Amount calculateAmount(int price) {
        return new Amount(money / price);
    }

    public long earningRate(long benefit) {
        return benefit / money * 100;
    }
}
