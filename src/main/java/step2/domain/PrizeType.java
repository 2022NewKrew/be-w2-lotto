package step2.domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PrizeType {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int hittingNum;
    private final int winningPrize;

    PrizeType(int hittingNum, int winningPrize) {
        this.hittingNum = hittingNum;
        this.winningPrize = winningPrize;
    }

    public int getHittingNum() {
        return hittingNum;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public static final Map<Integer, String> PRIZE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(PrizeType::getHittingNum, PrizeType::name))
    );

    public static PrizeType of(final Integer hittingNum){
        return PrizeType.valueOf(PRIZE_MAP.get(hittingNum));
    }
}
