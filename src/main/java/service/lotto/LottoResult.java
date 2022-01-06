package service.lotto;

import java.util.EnumSet;

public enum LottoResult {
    FIFTH_PLACE(5000, "3개 일치 (5000원)"),
    FOURTH_PLACE(50000, "4개 일치 (50000원)"),
    THIRD_PLACE(1500000, "5개 일치 (1500000원)"),
    SECOND_PLACE(30000000, "5개 일치, 보너스 볼 일치(30000000원)"),
    FIRST_PLACE(2000000000, "6개 일치 (2000000000원)"),
    UNWINNABLE(0, "미당첨"),
    UNIDENTIFIED(0, "미확인");

    private final int prizeMoney;
    private final String str;

    LottoResult(int prizeMoney, String str) {
        this.prizeMoney = prizeMoney;
        this.str = str;
    }

    public static LottoResult of(int score, boolean isBonusBallMatched) {
        if (score == 6) {
            return FIRST_PLACE;
        } else if (score == 5) {
            return isBonusBallMatched ? SECOND_PLACE : THIRD_PLACE;
        } else if (score == 4) {
            return FOURTH_PLACE;
        } else if (score == 3) {
            return FIFTH_PLACE;
        }
        return UNWINNABLE;
    }

    public static EnumSet<LottoResult> getEnumSetRankedPlace() {
        return EnumSet.of(
                LottoResult.FIFTH_PLACE,
                LottoResult.FOURTH_PLACE,
                LottoResult.THIRD_PLACE,
                LottoResult.SECOND_PLACE,
                LottoResult.FIRST_PLACE
        );
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return str;
    }
}
