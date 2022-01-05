package lotto.domain.lotto;

public enum MatchType {
    UNMATCHED,
    THREE,
    FOUR,
    FIVE,
    FIVE_BONUS,
    SIX;

    public static MatchType match(int matchCount, boolean bonusNeed) {
        if (matchCount == 6) {
            return SIX;
        }
        if (matchCount == 5 && bonusNeed) {
            return FIVE_BONUS;
        }
        if (matchCount == 5) {
            return FIVE;
        }
        if (matchCount == 4) {
            return FOUR;
        }
        if (matchCount == 3) {
            return THREE;
        }
        return UNMATCHED;
    }
}
