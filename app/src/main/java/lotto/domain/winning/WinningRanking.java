package lotto.domain.winning;

import java.util.HashMap;
import java.util.Map;

public enum WinningRanking {
    FIRST(6),
    SECOND( 5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    UNRANKED(0);

    private final int matchCount;

    WinningRanking(int matchCount) {
        this.matchCount = matchCount;
    }

    public static WinningRanking match(int matchCount, boolean bonusMatching) {
        if(matchCount == 6) {
            return FIRST;
        }
        if(matchCount == 5 && bonusMatching) {
            return SECOND;
        }
        if(matchCount == 5) {
            return THIRD;
        }
        if(matchCount == 4) {
            return FOURTH;
        }
        if(matchCount == 3) {
            return FIFTH;
        }
        return UNRANKED;
    }
}
