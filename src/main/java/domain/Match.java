package domain;

public class Match {
    private Match() {
    }

    public static Ranking makeLottoRank(Lotto lotto, Lotto prize, int bonus) {
        switch (lotto.countNumbersMatch(prize)) {
            case 3:
                return Ranking.THREE;
            case 4:
                return Ranking.FOUR;
            case 5:
                return bonusBallRank(lotto, bonus);
            case 6:
                return Ranking.SIX;
            default:
                return Ranking.NONE;
        }
    }

    private static Ranking bonusBallRank(Lotto lotto, int bonus) {
        if (lotto.contains(bonus))
            return Ranking.SIX_SECOND;
        return Ranking.FIVE;
    }
}
