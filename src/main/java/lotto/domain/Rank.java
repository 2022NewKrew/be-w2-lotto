package lotto.domain;

import java.util.List;

public enum Rank {
    FIRST(6, 2000000000, "(2000000000원)"),
    SECOND_WITH_BONUS(5, 30000000, "보너스 볼 일치(30000000원)"),
    SECOND(5, 1500000, "(1500000원)"),
    THIRD(4, 50000, "(50000원)"),
    FOURTH(3, 5000, "(5000원)"),
    NONE(0, 0, "");

    private int countOfMatch;
    private int winningMoney;
    private String winningMessage;

    private Rank(int countOfMatch, int winningMoney, String winningMessage) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.winningMessage = winningMessage;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    static public Rank getRankByCount(int count, Boolean matchBonus){
        List<Rank> ranks = List.of(Rank.values());
        for(int i = 0 ; i < ranks.size() ; i++){
            if(count == SECOND.getCountOfMatch() && ranks.get(i).countOfMatch == SECOND.getCountOfMatch()){
                return (matchBonus ? SECOND_WITH_BONUS : SECOND);
            }

            if(ranks.get(i).countOfMatch == count){
                return ranks.get(i);
            }
        }
        return NONE;
    }
}