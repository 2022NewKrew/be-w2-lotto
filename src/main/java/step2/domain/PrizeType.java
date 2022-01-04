package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PrizeType {
    THREE(3, 5000, "3개 일치"),
    FOUR(4, 50000, "4개 일치"),
    FIVE(5, 1500000, "5개 일치"),
    FIVE_AND_BONUS(99, 30000000, "5개 일치, 보너스 볼 일치"),
    SIX(6, 2000000000, "6개 일치");

    private final int hittingNum;
    private final int winningPrize;
    private final String printingString;

    PrizeType(int hittingNum, int winningPrize, String printingString) {
        this.hittingNum = hittingNum;
        this.winningPrize = winningPrize;
        this.printingString = printingString;
    }

    public int getHittingNum() {
        return hittingNum;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public String getPrintingString() {
        return printingString;
    }

    public static final Map<Integer, String> PRIZE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(PrizeType::getHittingNum, PrizeType::name))
    );

    public static PrizeType of(final Integer hittingNum){
        return PrizeType.valueOf(PRIZE_MAP.get(hittingNum));
    }
}
