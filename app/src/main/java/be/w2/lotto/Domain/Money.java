package be.w2.lotto.Domain;

public class Money {

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int calculateAmount(int price) {
        return money / price;
    }

    public int calEarningRate(int benefit) {
        return benefit * 100 / money;
    }
}
