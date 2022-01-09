package model.lotto;

import java.util.Arrays;

public enum LottoRank {
    FAIL(0, false, 0),
    FIFTH_PRIZE(3, false, 5_000),
    FORTH_PRIZE(4, false, 50_000),
    THIRD_PRIZE(5, false, 1_500_000),
    SECOND_PRIZE(5, true, 30_000_000),
    FIRST_PRIZE(6, false, 2_000_000_000);

    private final int reward;
    private final int matchNumber;
    private final boolean needBonusNumber;

    LottoRank(int matchNumber, boolean needBonusNumber, int reward) {
        this.matchNumber = matchNumber;
        this.needBonusNumber = needBonusNumber;
        this.reward = reward;
    }

    public static LottoRank convertToLottoRank(int numberOfSameNumber, boolean needBonusNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.compareBy(numberOfSameNumber, needBonusNumber))
                .findFirst()
                .orElse(LottoRank.FAIL);
    }

    private boolean compareBy(int numberOfSameNumber, boolean needBonusNumber) {
        if (this == LottoRank.SECOND_PRIZE || this == LottoRank.THIRD_PRIZE) {
            return getMatchNumber() == numberOfSameNumber && getNeedBonusNumber() == needBonusNumber;
        }
        return getMatchNumber() == numberOfSameNumber;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public boolean getNeedBonusNumber() {
        return needBonusNumber;
    }
}
