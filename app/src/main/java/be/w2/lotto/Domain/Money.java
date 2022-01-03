package be.w2.lotto.Domain;

public class Money {

    private int money;

    public Money(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("돈은 0원 이상 입력받아야합니다!");
        }
        this.money = money;
    }

    public int calculateAmount(int price) {
        return money / price;
    }

    public int calEarningRate(int benefit) {
        return benefit * 100 / money;
    }
}
