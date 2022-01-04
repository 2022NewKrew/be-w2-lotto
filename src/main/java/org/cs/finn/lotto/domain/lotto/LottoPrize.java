package org.cs.finn.lotto.domain.lotto;

import org.cs.finn.lotto.util.Checker;
import org.cs.finn.lotto.util.NumberFormatter;

import java.util.Arrays;
import java.util.stream.Stream;

public enum LottoPrize {
    NONE("꽝", 0, 0, false),
    MATCH3("3개 일치", 5_000, 3, false),
    MATCH4("4개 일치", 50_000, 4, false),
    MATCH5("5개 일치", 1_500_000, 5, false),
    MATCH5B("5개 + 보너스 번호 일치", 30_000_000, 5, true),
    MATCH6("6개 일치", 2_000_000_000, 6, false);

    private final String condition;
    private final int reward;
    private final int reqMatch;
    private final boolean reqBonusMatch;

    LottoPrize(
            final String condition,
            final int reward,
            final int reqMatch,
            final boolean reqBonusMatch
    ) throws IllegalArgumentException, IllegalStateException
    {
        Checker.checkString(condition);
        Checker.checkInt(reward, false);
        Checker.checkInt(reqMatch, false);
        this.condition = condition.trim();
        this.reward = reward;
        this.reqMatch = reqMatch;
        this.reqBonusMatch = reqBonusMatch;
    }

    public static LottoPrize find(final int reqMatch, final boolean reqBonusMatch) {
        final Stream<LottoPrize> filtered = Arrays.stream(values())
                .filter(p -> (p.reqMatch == reqMatch));

        if (filtered.anyMatch(p -> (p.reqBonusMatch == reqBonusMatch))) {
            return filtered.filter(p -> (p.reqBonusMatch == reqBonusMatch))
                    .findFirst()
                    .orElse(NONE);
        }

        return filtered.findFirst()
                .orElse(NONE);
    }

    @Override
    public String toString() {
        return condition + " (" + NumberFormatter.strNumberWithSeparator(reward) + "원)";
    }

}
