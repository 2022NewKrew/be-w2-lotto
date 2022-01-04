package lotto.domain.result;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum LottoResultType {

    THREE_MATCH(3, 5000, "%d개 일치 (%d원)- %d개\n"),
    FOUR_MATCH(4, 50000, "%d개 일치 (%d원)- %d개\n"),
    FIVE_MATCH(5, 1500000, "%d개 일치 (%d원)- %d개\n"),
    FIVE_MATCH_WITH_BONUS(5, 30000000, "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n"),
    SIX_MATCH(6, 2000000000, "%d개 일치 (%d원)- %d개\n");

    public static final int MIN_MATCH_NUMBER_COUNT = 3;
    private final int matchingNumberCount;
    private final int money;

    private final String formatStrOfResult;

    LottoResultType(int matchingNumberCount, int money, String formatStrOfResult) {
        this.matchingNumberCount = matchingNumberCount;
        this.money = money;
        this.formatStrOfResult = formatStrOfResult;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getMoney() {
        return money;
    }

    public String getFormatStrOfResult() {
        return formatStrOfResult;
    }

    public static LottoResultType getLottoResultType(int matchNumberCount) {
        return Arrays.stream(LottoResultType.values())
                .filter(lottoResultType -> lottoResultType.getMatchingNumberCount() == matchNumberCount)
                .collect(Collectors.toList())
                .get(0);
    }
}
