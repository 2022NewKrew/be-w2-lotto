package be.w2.lotto.result;

import java.util.Optional;

public enum Winnings {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_AND_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private int howManyCorrect;
    private int reward;

    Winnings(int howManyCorrect, int reward) {
        this.howManyCorrect = howManyCorrect;
        this.reward = reward;
    }

    public int getHowManyCorrect() {
        return howManyCorrect;
    }

    public int getReward() {
        return reward;
    }

    static Optional<Winnings> getWinningsByHowManyCorrect(CorrectSpec correctSpec) {
        if(isFiveAndBonus(correctSpec))
            return Optional.of(FIVE_AND_BONUS);
        for (Winnings winnings : Winnings.values()) {
            if (winnings.getHowManyCorrect() == correctSpec.getNumOfCorrect())
                return Optional.of(winnings);
        }
        return Optional.empty();
    }

    private static boolean isFiveAndBonus(CorrectSpec correctSpec) {
        return correctSpec.getNumOfCorrect() == FIVE_AND_BONUS.howManyCorrect && correctSpec.isContainBonus();
    }
}
