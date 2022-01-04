package service.lotto;

import java.util.EnumSet;

public enum LottoResult {
    FOURTH_PLACE(5000, "3개 일치 (5000원)"),
    THIRD_PLACE(50000, "4개 일치 (50000원)"),
    SECOND_PLACE(1500000, "5개 일치 (1500000원)"),
    FIRST_PLACE(2000000000, "6개 일치 (2000000000원)"),
    UNWINNABLE(0, "미당첨"),
    UNIDENTIFIED(0, "미확인");


    private final int prizeMoney;
    private final String str;


    LottoResult(int prizeMoney, String str) {
        this.prizeMoney = prizeMoney;
        this.str = str;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoResult of(int score) {
        if (score == 6) {
            return FIRST_PLACE;
        } else if (score == 5) {
            return SECOND_PLACE;
        } else if (score == 4) {
            return THIRD_PLACE;
        } else if (score == 3) {
            return FOURTH_PLACE;
        }
        return UNWINNABLE;
    }

    @Override
    public String toString() {
        return str;
    }

    public static EnumSet<LottoResult> getEnumSetFirstToFourthPlace() {
        return EnumSet.of(
                LottoResult.FOURTH_PLACE,
                LottoResult.THIRD_PLACE,
                LottoResult.SECOND_PLACE,
                LottoResult.FIRST_PLACE
        );
    }


}
