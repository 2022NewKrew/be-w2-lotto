package com.kakaocorp.lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoResult {
    /*
     * FIXME Rule 객체 등을 이용해 외부에서 가격을 주입받고 싶은데
     * enum을 사용하면 그럴 수 없는 문제가 있어 고민 중
     */
    FIRST(6, 2000000000),
    SECOND( 5, 1500000),
    THIRD( 4, 50000),
    FOURTH(3, 5000),
    LOSE(0, 0),
    ;

    private static final Comparator<LottoResult> RANK_COMPARATOR_ASC = Comparator.comparingInt(a -> -a.matches);

    private final int matches;
    private final int value;

    LottoResult(int matches, int value) {
        this.matches = matches;
        this.value = value;
    }

    // FIXME ui 단에서 처리하는 것이 맞지 않나 하는 생각
    public String toPrintString(int count) {
        return String.format("%d개 일치 (%d원)- %d개", matches, value, count);
    }

    public static LottoResult get(int matches) {
        return Arrays.stream(values())
                .filter(lottoResult -> lottoResult.matches == matches)
                .findFirst()
                .orElse(LottoResult.LOSE);
    }

    public static List<LottoResult> orderWinsByRankAsc() {
        return Arrays.stream(values())
                .filter(x -> x != LottoResult.LOSE)
                .sorted(RANK_COMPARATOR_ASC)
                .collect(Collectors.toList());
    }

    public int accumulate(int totalGain, int count) {
        return totalGain + value * count;
    }
}
