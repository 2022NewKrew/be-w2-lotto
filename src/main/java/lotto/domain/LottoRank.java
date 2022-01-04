package lotto.domain;

public enum LottoRank {
    FIFTH(5,3, 5_000),
    FOURTH(4,4, 50_000),
    THIRD(3,5, 1_500_000),
    SECOND(2,5, 30_000_000),
    FIRST(1, 6, 2_000_000_000);


    private final int resultRank;
    private final int countOfMatch;
    private final int winningPrize;

    LottoRank(int resultRank, int countOfMatch, int winningPrize){
        this.resultRank = resultRank;
        this.countOfMatch = countOfMatch;
        this.winningPrize = winningPrize;
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus){
        LottoRank[] ranks = values();
        LottoRank result = null;
        for(LottoRank rank: ranks){
            result = (result == null) ? findRank(rank, countOfMatch, matchBonus) : result;
        }
        return result;
    }

    private static LottoRank findRank(LottoRank rank, int countOfMatch, boolean matchBonus){
        if(countOfMatch == SECOND.countOfMatch){
            return matchBonus ? SECOND : THIRD;
        }
        if(rank.countOfMatch == countOfMatch){
            return rank;
        }
        return null;
    }

    public int getResultRank() { return resultRank; }
    public int getCountOfMatch() { return countOfMatch; }
    public int getWinningPrize() { return winningPrize; }
}
