package domain;

import domain.lottery.Result;
import domain.lottery.Ticket;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    None(0, 0);

    private static final Map<Integer, Prize> matchingCountToPrize;

    static {
        matchingCountToPrize = new HashMap<>();
        // Notice that the second prize is overwritten by the third prize.
        // This is kind of tricky, confusing and probably not safe.
        // Need a better approach.
        Arrays.asList(Prize.values()).forEach(prize -> matchingCountToPrize.put(prize.winningMatchingCount, prize));
    }

    private final int winningMatchingCount;
    private final int value;

    Prize(int winningMatchingCount, int value) {
        this.winningMatchingCount = winningMatchingCount;
        this.value = value;
    }

    public static Prize getPrize(Result result, Ticket ticket) {
        Prize prize = matchingCountToPrize.getOrDefault(result.getMatchingCountOf(ticket), Prize.None);
        return prize.equals(Prize.THIRD) && result.isBonusBallMatched(ticket) ? Prize.SECOND : prize;
    }

    public int getWinningMatchingCount() {
        return winningMatchingCount;
    }

    public int getValue() {
        return value;
    }
}
