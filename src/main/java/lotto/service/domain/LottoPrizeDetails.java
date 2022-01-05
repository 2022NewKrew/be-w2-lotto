package lotto.service.domain;

import java.util.EnumSet;

public enum LottoPrizeDetails implements Comparable<LottoPrizeDetails>{
    UNIDENTIFIED(-1, "미확인"),
    NO_PRIZE(0, "미당첨"),
    FIFTH_PRIZE(5000, "3개 일치 (5000원)"),
    FOURTH_PRIZE(50000, "4개 일치 (50000원)"),
    THIRD_PRIZE(1500000, "5개 일치 (1500000원)"),
    SECOND_PRIZE(30000000, "5개 일치, 보너스 볼 일치(30000000원)"),
    FIRST_PRIZE(2000000000, "6개 일치 (2000000000원)");

    private final long prize;
    private final String resultStr;

    LottoPrizeDetails(long prize, String resultStr) {
        this.prize = prize;
        this.resultStr = resultStr;
    }
    protected long getPrize(){
        return prize;
    }

    public String getResultStr() {
        return resultStr;
    }

    @Override
    public String toString() {
        return resultStr;
    }

    public static EnumSet<LottoPrizeDetails> getEnumSetAllPrize(){
        return EnumSet.of(
                LottoPrizeDetails.FIFTH_PRIZE,
                LottoPrizeDetails.FOURTH_PRIZE,
                LottoPrizeDetails.THIRD_PRIZE,
                LottoPrizeDetails.SECOND_PRIZE,
                LottoPrizeDetails.THIRD_PRIZE
        );
    }
}
