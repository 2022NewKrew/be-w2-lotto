package domain;

public enum LottoMatch {
    ETC(3, false),
    FOURTH(4, false),
    THIRD(5, false),
    SECOND(5, true),
    FIRST(6, false);

    private final int matches;
    private final boolean bonus;

    LottoMatch(int matches, boolean bonus) {
        this.matches = matches;
        this.bonus = bonus;
    }

    public int getMatches() {
        return matches;
    }

    public boolean isBonus() {
        return bonus;
    }
}
