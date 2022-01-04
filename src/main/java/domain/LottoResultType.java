package domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum LottoResultType {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    public static final int MIN_MATCH_NUMBER_COUNT = 3;
    private final int matchNumberCount;
    private final int money;

    LottoResultType(int matchNumberCount, int money) {
        this.matchNumberCount = matchNumberCount;
        this.money = money;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getMoney() {
        return money;
    }

    public static LottoResultType getLottoResultType(int matchNumberCount) {
        return Arrays.stream(LottoResultType.values())
                .filter(lottoResultType -> lottoResultType.getMatchNumberCount() == matchNumberCount)
                .collect(Collectors.toList())
                .get(0);
    }
}
