package be.w2.lotto.result;

public enum RewardForCorrect {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

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
