package enums;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false,2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false,1500000),
    FOURTH(4, false,50000),
    FIFTH(3,false, 5000),
    SIXTH(2, false,0),
    SEVENTH(1,false, 0),
    EIGHTH(0,false, 0);

    private final int countOfMatch;
    private final boolean bonus;
    private final int winningMoney;

    private Rank(int countOfMatch, boolean bonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.bonus = bonus;
        this.winningMoney = winningMoney;
    }

    public static Rank getRank(int countOfMatch,boolean bonus){
        return Arrays.stream(values())
                .filter(x -> (x.countOfMatch == countOfMatch))
                .filter(x -> !x.bonus || bonus)
                .findFirst()
                .orElse(Rank.EIGHTH);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}
