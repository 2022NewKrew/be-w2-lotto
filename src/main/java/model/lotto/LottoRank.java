package model.lotto;

import java.util.Arrays;

public enum LottoRank {
    FAIL(0, false, 0),
    FIFTH_PRIZE(3, false, 5000),
    FORTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 1500000),
    SECOND_PRIZE(5, true, 30000000),
    FIRST_PRIZE(6, false, 2000000000);

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
                .filter(lottoRank -> checkLottoRank(lottoRank, numberOfSameNumber, needBonusNumber))
                .findFirst()
                .orElse(LottoRank.FAIL);
    }

    private static boolean checkLottoRank(LottoRank lottoRank, int numberOfSameNumber, boolean needBonusNumber) {
        if (lottoRank == LottoRank.SECOND_PRIZE || lottoRank == LottoRank.THIRD_PRIZE) {
            return lottoRank.getMatchNumber() == numberOfSameNumber && lottoRank.getNeedBonusNumber() == needBonusNumber;
        }
        return lottoRank.getMatchNumber() == numberOfSameNumber;
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
