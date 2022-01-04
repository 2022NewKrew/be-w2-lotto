package lottoStage2.domain.winning;

import lottoStage2.domain.vo.Discrimination;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningType {
    LOSER(0, false, 0, "3개 이하 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    THIRD(5, false, 1_500_00, "5개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스볼 일치"),
    FIRST(6, true, 2_000_000_000, "6개 일치");

    private static final Map<Discrimination, String> MATCH_COUNT_MAP =
            Collections.unmodifiableMap(
                    Stream.of(values()).collect(Collectors.toMap(WinningType::getDiscrimination, WinningType::name)));


    private final Discrimination discrimination;
    private final int winnings;
    private final String message;

    WinningType(int matchCount, boolean matchBonus, int winnings, String message) {
        discrimination = new Discrimination(matchCount, matchBonus);
        this.winnings = winnings;
        this.message = message;
    }

    public static WinningType of(Discrimination discrimination) {
        if(discrimination.getMatchCount() < 3)
            return LOSER;
        return WinningType.valueOf(MATCH_COUNT_MAP.get(discrimination));
    }

    public Discrimination getDiscrimination() {
        return discrimination;
    }

    public int getWinnings() {
        return winnings;
    }

    public String getMessage() {
        return message;
    }
}
