package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2000000000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1500000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5000원)"),
    MISS(0, false, 0, "3개 미만 일치 (0원)");

    private final int matchCount;
    private final boolean bonusRequired;
    private final long prize;
    private final String description;

    Rank(int matchCount, boolean bonusRequired, long prize, String description) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
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
        if (matchCount < 0 || matchCount > FIRST.matchCount) {
            throw new IllegalArgumentException("당첨 정보가 올바르지 않습니다.");
        }

        return Arrays.stream(Rank.values())
                .filter((rank) -> rank.matchCount == matchCount)
                .filter((rank) -> !rank.bonusRequired || bonusMatched)
                .findFirst()
                .orElse(MISS);
    }
}
