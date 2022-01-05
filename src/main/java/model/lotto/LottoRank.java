package model.lotto;

import java.util.Arrays;

public enum LottoRank {
    FAIL(1, false, 0),
    FIFTH_PRIZE(2, false, 0),
    FORTH_PRIZE(3, false, 5000),
    THIRD_PRIZE(4, false, 50000),
    SECOND_PRIZE(5, false, 1500000),
    FIRST_PRIZE(6, false, 2000000000);

    private final int reward;
    private final int matchNumber;
    private final boolean needBonusNumber;

    LottoRank(int matchNumber, boolean needBonusNumber, int reward) {
        this.matchNumber = matchNumber;
        this.needBonusNumber = needBonusNumber;
        this.reward = reward;
    }

    public static LottoRank convertToLottoRank(int numberOfSameNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(l -> l.getMatchNumber() == numberOfSameNumber)
                .findFirst()
                .orElse(LottoRank.FAIL);
    }

    public int getReward() {
        return reward;
    }

    public int getMatchNumber(){
        return matchNumber;
    }

}
