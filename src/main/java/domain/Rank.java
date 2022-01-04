package domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank{
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney){
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus){
        Rank[] ranks = values();

        Optional<Rank> findRank = Arrays.stream(ranks)
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst();

        if(findRank.isPresent() && findRank.get().countOfMatch == SECOND.countOfMatch){
            return matchBonus ? SECOND : THIRD;
        }

        return findRank.orElse(NONE);
    }


}
