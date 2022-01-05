package model;

import java.util.EnumSet;

public enum LottoResult {
    UNIDENTIFIED(0, "미확인"),
    MATCH_NONE(0, "미당첨"),
    MATCH_THREE(5000, "3개 일치"),
    MATCH_FOUR(50000, "4개 일치"),
    MATCH_FIVE(1500000, "5개 일치"),
    MATCH_FIVE_WITH_BONUS(30000000, "5개 일치, 보너스 볼 일치"),
    MATCH_SIX(2000000000, "6개 일치");

    private final int prize;
    private final String msg;

    LottoResult(int prize, String msg) {
        this.prize = prize;
        this.msg = msg;
    }

    public int getPrize() {
        return prize;
    }

    public String getMsg() {
        return msg;
    }

    public static LottoResult of(int matchNumber, boolean includeBonus) {
        switch (matchNumber) {
            case 3:
                return MATCH_THREE;
            case 4:
                return MATCH_FOUR;
            case 5:
                return includeBonus ? MATCH_FIVE_WITH_BONUS : MATCH_FIVE;
            case 6:
                return MATCH_SIX;
        }
        return MATCH_NONE;
    }

    public static EnumSet<LottoResult> getEnumSet() {
        return EnumSet.of(
                MATCH_THREE,
                MATCH_FOUR,
                MATCH_FIVE,
                MATCH_FIVE_WITH_BONUS,
                MATCH_SIX
        );
    }
}
