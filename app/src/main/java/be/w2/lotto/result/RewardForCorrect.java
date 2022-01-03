package be.w2.lotto.result;

public enum RewardForCorrect {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int howManyCorrect;
    private int reward;

    RewardForCorrect(int howManyCorrect, int reward) {
        this.howManyCorrect = howManyCorrect;
        this.reward = reward;
    }

    public int getHowManyCorrect() {
        return howManyCorrect;
    }

    public int getReward() {
        return reward;
    }
}
