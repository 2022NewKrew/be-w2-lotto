package domain.prize;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {

    FIRST_PRIZE(6, false, 2_000_000_000),
    SECOND_PRIZE(5, true, 30_000_000),
    THIRD_PRIZE(5, false, 1_500_000),
    FOURTH_PRIZE(4, false, 50000),
    FIFTH_PRIZE(3, false, 5000),
    NO_PRIZE(0, false, 0);

    private final int matchedNum;
    private final boolean matchedBonus;
    private final int prizeMoney;

    Prize(int matchedNum, boolean matchedBonus, int prizeMoney) {
        this.matchedNum = matchedNum;
        this.matchedBonus = matchedBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(int matchedNum, boolean matchedBonus) {
        return Arrays.stream(values())
                .filter(p -> isEqualMatchedNum(p, matchedNum))
                .filter(p -> checkBonusPrize(p, matchedBonus))
                .findFirst()
                .orElse(NO_PRIZE);
    }

    private static boolean isEqualMatchedNum(Prize prize, int matchedNum) {
        return prize.matchedNum == matchedNum;
    }

    private static boolean checkBonusPrize(Prize prize, boolean matchedBonus) {
        return !prize.isMatchedBonus() || matchedBonus;
    }

    public int getMatchedNum() {
        return matchedNum;
    }

    public boolean isMatchedBonus() {
        return matchedBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static List<Prize> getTypeList() {
        return Arrays.stream(values())
                .filter(p -> p != NO_PRIZE)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }
}
