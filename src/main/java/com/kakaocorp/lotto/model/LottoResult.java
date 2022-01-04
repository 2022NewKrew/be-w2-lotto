package com.kakaocorp.lotto.model;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoResult {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    LOSE(0, false, 0),
    ;

    public static final Comparator<LottoResult> VALUE_COMPARATOR_ASC = Comparator.comparingInt(a -> -a.value);

    private final int matches;
    private final boolean bonus;
    private final int value;

    LottoResult(int matches, boolean bonus, int value) {
        this.matches = matches;
        this.bonus = bonus;
        this.value = value;
    }

    // FIXME ui 단에서 처리하는 것이 맞지 않나 하는 생각
    public String toPrintString(int count) {
        if (bonus) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개", matches, value, count);
        }
        return String.format("%d개 일치 (%d원)- %d개", matches, value, count);
    }

    public static LottoResult get(int matches, boolean bonus) {
        return Arrays.stream(values())
                .filter(x -> (x.matches == matches) && (!x.bonus || bonus))
                .findFirst()
                .orElse(LottoResult.LOSE);
    }

    public int getValue(int count) {
        return value * count;
    }
}
