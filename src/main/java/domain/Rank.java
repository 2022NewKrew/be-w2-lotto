package domain;

public enum Rank {
    MISS(0, 0, "3개 미만 일치 (0원)"),
    FOURTH(3, 5_000, "3개 일치 (5000원)"),
    THIRD(4, 50_000, "4개 일치 (50000원)"),
    SECOND(5, 1_500_000, "5개 일치 (1500000원)"),
    FIRST(6, 2_000_000_000, "6개 일치 (2000000000원)");

    private final int matchCount;
    private final long prize;
    private final String description;

    Rank(int matchCount, long prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public long getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static Rank valueOf(int matchCount) {
        if (matchCount < 3) {
            return MISS;
        }

        if (FIRST.matchCount == matchCount) {
            return FIRST;
        }

        if (SECOND.matchCount == matchCount) {
            return SECOND;
        }

        if (THIRD.matchCount == matchCount) {
            return THIRD;
        }

        if (FOURTH.matchCount == matchCount) {
            return FOURTH;
        }

        throw new IllegalArgumentException();
    }
}
