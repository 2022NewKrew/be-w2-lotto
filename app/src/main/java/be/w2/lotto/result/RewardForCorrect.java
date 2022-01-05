package be.w2.lotto.result;

import java.util.Optional;

public enum RewardForCorrect {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_AND_BONUS(5, 30_000_000),
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

    static Optional<RewardForCorrect> getRewordForCorrectByHowManyCorrect(CorrectSpec correctSpec) {
        if(isFiveAndBonus(correctSpec))
            return Optional.of(FIVE_AND_BONUS);
        for (RewardForCorrect rewardForCorrect : RewardForCorrect.values()) {
            if (rewardForCorrect.getHowManyCorrect() == correctSpec.getNumOfCorrect())
                return Optional.of(rewardForCorrect);
        }
        return Optional.empty();
    }

    private static boolean isFiveAndBonus(CorrectSpec correctSpec) {
        return correctSpec.getNumOfCorrect() == FIVE_AND_BONUS.getHowManyCorrect() && correctSpec.isContainBonus();
    }
}
