package domain;

import static domain.util.LotteryConfigs.TICKET_PRICE;

public class LotteryWallet {
    private int budget;
    private int spent;

    public int getSpent() {
        return spent;
    }

    public LotteryWallet(int budget) {
        this.budget = budget;
    }

    public void buyTickets(int numberOfTickets) {
        pay(TICKET_PRICE * numberOfTickets);
    }

    public int getNumberOfTicketsAffordable() {
        return budget / TICKET_PRICE;
    }

    private void pay(int money) {
        if (budget < money) {
            throw new IllegalArgumentException("잔액 " + budget + "은 " + money + "을 지불하기에 부족합니다.");
        }
        budget -= money;
        spent += money;
    }
}
