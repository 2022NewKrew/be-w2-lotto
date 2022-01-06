package domain;

public class Match {
    public static Ranking makeLottoRank(Lotto lotto, Lotto prize) {
        switch (lotto.countNumbersMatch(prize)) {
            case 3:
                return Ranking.THREE;
            case 4:
                return Ranking.FOUR;
            case 5:
                return Ranking.FIVE;
            case 6:
                return Ranking.SIX;
            default:
                return Ranking.NONE;
        }
    }
}
