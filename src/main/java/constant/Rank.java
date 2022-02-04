package constant;

public enum Rank {
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int match;
    private final long reward;
    private final boolean bonus;

    Rank(int match, long reward, boolean bonus) {
        this.match = match;
        this.reward = reward;
        this.bonus = bonus;
    }

    public int getMatch() {
        return match;
    }

    public long getReward() {
        return reward;
    }

    public static Rank valueOf(int match, boolean bonus) {
        Rank[] ranks = values();

        for (Rank rank : ranks) {
            if (match == SECOND.getMatch()) {
                return bonus ? SECOND : THIRD;
            }
            if (match == rank.getMatch()) {
                return rank;
            }
        }
        return null;
    }
}
