package lotto.util;

public enum Rank {
    FIRST(6, false,2000000000),
    SECOND(5, true,30000000),
    THIRD(5, false,1500000),
    FOURTH(4, false,50000),
    FIFTH(3, false,5000);

    private int countOfMatch;
    private int winningMoney;
    private boolean bonusMatch;
    private int countWin;

    private Rank(int countOfMatch, boolean bonusMatch ,int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.bonusMatch = bonusMatch;
        this.winningMoney = winningMoney;
        this.countWin = 0;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public void counting(){
        this.countWin = this.countWin + 1;
    }

    public void checkAndCount(int matchNumber, boolean bonus){
        if (matchNumber == countOfMatch && countOfMatch == 5 && bonus == bonusMatch){
            counting();
            return;
        }
        if (matchNumber == countOfMatch && countOfMatch != 5){
            counting();
            return;
        }
    }

    public int getResultCount(){
        return this.countWin;
    }
}
