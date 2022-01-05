package lotto.domain.result;

import lotto.domain.lotto.MatchType;

import java.util.function.Function;

public enum WinningRanking {
    FIRST(v -> v * 2_000_000_000),
    SECOND(v -> v * 30_000_000),
    THIRD(v -> v * 1_500_000),
    FOURTH(v -> v * 50_000),
    FIFTH(v -> v * 5_000),
    UNRANKED(v -> 0);

    private final Function<Integer, Integer> expression;

    WinningRanking(Function<Integer, Integer> expression) {
        this.expression = expression;
    }

    public static WinningRanking match(MatchType matchType) {
        if (MatchType.SIX.equals(matchType)) {
            return FIRST;
        }
        if (MatchType.FIVE_BONUS.equals(matchType)) {
            return SECOND;
        }
        if (MatchType.FIVE.equals(matchType)) {
            return THIRD;
        }
        if (MatchType.FOUR.equals(matchType)) {
            return FOURTH;
        }
        if (MatchType.THREE.equals(matchType)) {
            return FIFTH;
        }
        return UNRANKED;
    }

    public int calculatePrizeAccordingToRanking(long count) {
        return expression.apply((int) count);
    }
}
