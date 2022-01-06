package lotto.util;


/**
 * 등수 정보 및 등수 확인을 위한 enum
 */
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

    /**
     * 전체 등수를 탐색하며 몇 등인지를 확인하여 해당 객체를 반환하는 메소드
     * @param countOfMatch 일치하는 숫자 수
     * @param matchBonus 보너스 볼 일치 여부
     * @return 확인된 LottoRank 객체
     */
    public static LottoRank valueOf(int countOfMatch, boolean matchBonus){
        LottoRank[] ranks = values();
        LottoRank result = null;
        for(LottoRank rank: ranks){
            result = (result == null) ? findRank(rank, countOfMatch, matchBonus) : result;
        }
        return result;
    }

    /**
     * parameter 로 받은 LottoRank가 다른 입력 값과 조건이 일치하는 지 확인하여 반환하는 메소드
     * @param rank 비교 등수
     * @param countOfMatch 일치하는 숫자 수
     * @param matchBonus 보너스 볼 일치 여부
     * @return 일치한다면 해당 rank, 아니라면 null
     */
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
