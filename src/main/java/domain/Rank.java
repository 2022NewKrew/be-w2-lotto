package domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, false, 0, "3개 미만 일치 (0원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1500000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2000000000원)");

    private final int matchCount;
    private final boolean bonusMatched;
    private final long prize;
    private final String description;

    Rank(int matchCount, boolean bonusMatched, long prize, String description) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.prize = prize;
        this.description = description;
    }

    public long getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatched) {
        if (matchCount < 0) {
            throw new IllegalArgumentException("당첨 정보가 올바르지 않습니다.");
        }

        if (bonusMatched && matchCount == SECOND.matchCount) {
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter((rank) -> rank.matchCount == matchCount)
                .filter((rank) -> !rank.bonusMatched)
                .findFirst()
                .orElse(MISS);
    }
}
