package lotto.util;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000){
        @Override
        public String toString(){
            return getCountOfMatch()+"개 일치, 보너스 볼 일치 ("+getWinningMoney()+")";
        }
    },
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String toString(){
        return getCountOfMatch()+"개 일치 ("+getWinningMoney()+")";
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (countOfMatch == SECOND.countOfMatch) {
                return matchBonus ? SECOND : THIRD;
            }
            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }
        return NONE;
    }
}
