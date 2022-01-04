package lottoStage2.domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningType {
    SEVENTH(0, 0),
    SIXTH(1, 0),
    FIFTH(2, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private static final Map<Integer, String> MATCH_COUNT_MAP =
            Collections.unmodifiableMap(
                    Stream.of(values()).collect(Collectors.toMap(WinningType::getMatchCount, WinningType::name)));


    private int matchCount;
    private int winnings;

    WinningType(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static WinningType of(final int matchCount) {
        return WinningType.valueOf(MATCH_COUNT_MAP.get(matchCount));
    }

    public int getMatchCount() {
        return matchCount;
    }
    public int getWinnings() {
        return winnings;
    }
}
