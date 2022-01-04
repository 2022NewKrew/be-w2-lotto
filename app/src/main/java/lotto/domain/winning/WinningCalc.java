package lotto.domain.winning;

import java.util.function.Function;

public enum WinningCalc {
    FIRST_CALC(v -> v*2000000000),
    SECOND_CALC(v -> v*30000000),
    THIRD_CALC(v -> v*1500000),
    FOURTH_CALC(v -> v*50000),
    FIFTH_CALC(v -> v*5000),
    UNRANKED_CALC(v -> 0);

    private Function<Integer, Integer> expression;

    WinningCalc(Function<Integer, Integer> expression) {
        this.expression = expression;
    }

    public static WinningCalc findCalc(String rank) {
        if(rank.equals("FIRST")) {
            return FIRST_CALC;
        }
        if(rank.equals("SECOND")) {
            return SECOND_CALC;
        }
        if(rank.equals("THIRD")) {
            return THIRD_CALC;
        }
        if(rank.equals("FOURTH")) {
            return FOURTH_CALC;
        }
        if(rank.equals("FIFTH")) {
            return FIFTH_CALC;
        }
        return UNRANKED_CALC;
    }

    public int calc(long count) {
        return expression.apply((int) count);
    }
}
