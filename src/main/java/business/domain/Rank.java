package business.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2000000000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1500000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50000원)"),
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

    public static Rank valueOf(MatchCount matchCount, BonusNumberMatched bonusNumberMatched) {
        return Arrays.stream(Rank.values()).filter((rank) -> matchCount.equals(rank.matchCount))
            .filter((rank) -> !rank.bonusRequired || bonusNumberMatched.getValue()).findFirst()
            .orElse(MISS);
    }

    public Money getPrize() {
        return new Money(this.prize);
    }

    public String getDescription() {
        return description;
    }
}
