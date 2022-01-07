package model.lotto;

import java.util.Arrays;

public enum LottoRank {
    FAIL(6, 0, false, 0),
    FIFTH_PRIZE(5, 3, false, 5_000),
    FORTH_PRIZE(4, 4, false, 50_000),
    THIRD_PRIZE(3, 5, false, 1_500_000),
    SECOND_PRIZE(2, 5, true, 30_000_000),
    FIRST_PRIZE(1, 6, false, 2_000_000_000);

    private final int rank;
    private final int reward;
    private final int matchNumber;
    private final boolean needBonusNumber;

    LottoRank(int rank, int matchNumber, boolean needBonusNumber, int reward) {
        this.rank = rank;
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

    public static LottoRank findLottoRankByRank(int rank) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getRank() == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 순위를 입력해야 합니다."));
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

    public int getRank() {
        return rank;
    }
}
