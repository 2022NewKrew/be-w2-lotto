package org.cs.finn.lotto.domain.lotto;

import org.cs.finn.lotto.util.Checker;
import org.cs.finn.lotto.util.NumberFormatter;

import java.util.Arrays;

public enum LottoPrize {
    NONE("꽝", 0),
    MATCH3("3개 일치", 5_000),
    MATCH4("4개 일치", 50_000),
    MATCH5("5개 일치", 1_500_000),
    MATCH5B("5개 + 보너스 번호 일치", 30_000_000),
    MATCH6("6개 일치", 2_000_000_000);

    private final String condition;
    private final int reward;

    LottoPrize(
            final String condition,
            final int reward
    ) throws IllegalArgumentException, IllegalStateException
    {
        Checker.checkString(condition);
        Checker.checkInt(reward, false);
        this.condition = condition.trim();
        this.reward = reward;
    }

    public static LottoPrize find(final int cntMatch, final boolean bonusFound) {
        final LottoPrize lottoPrize = findByString("MATCH" + cntMatch + (bonusFound ? "B" : ""));
        if (lottoPrize.isNone()) {
            return findByString("MATCH" + cntMatch);
        }

        return lottoPrize;
    }

    private static LottoPrize findByString(String value) {
        try {
            return valueOf(value);
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }

    public boolean isNone() {
        return this.equals(NONE);
    }

    public long getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return condition + " (" + NumberFormatter.strNumberWithSeparator(reward) + "원)";
    }
}
