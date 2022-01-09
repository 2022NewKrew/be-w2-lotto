package step1.domain;

public class Money {

    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public void useMoney(int amount) {
        if (this.amount < amount) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        this.amount -= amount;
        System.out.println("잔액 : " + this.amount);
    }

    public int getAmount() {
        return amount;
    }
}
