package domain.lotto;

public enum LottoRank {
    FIRST_PRIZE(1, 2000000000), SECOND_PRIZE(2, 1500000), THIRD_PRIZE(3, 50000), FORTH_PRIZE(4, 5000), FIFTH_PRIZE(5, 0), FAIL(6, 0);

    private final int price;
    private final int reward;

    LottoRank(int price, int reward) {
        this.price = price;
        this.reward = reward;
    }

    public int getPrice() {
        return price;
    }

    public int getReward() {
        return reward;
    }

}
