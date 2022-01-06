package domain.entity;

import java.util.Map;
import java.util.TreeMap;

public class LottoPolicy {

    public enum Rank { FIFTH, FOURTH, THIRD, SECOND, FIRST, NONE }

    public Rank resultToRank(LottoResult lottoResult) {
        int matchedNum = lottoResult.getMatchedNums();
        boolean isBonusNumMatched = lottoResult.isBonusNumMatched();

        if(isBonusNumMatched)
            return (matchedNum == 5) ? Rank.SECOND : Rank.NONE;

        switch (matchedNum) {
            case 3:
                return Rank.FIFTH;
            case 4:
                return Rank.FOURTH;
            case 5:
                return Rank.THIRD;
            case 6:
                return Rank.FIRST;
            default:
                return Rank.NONE;
        }
    }

    public LottoResult rankToResult(Rank rank) {
        switch (rank) {
            case FIFTH:
                return new LottoResult(3, false);
            case FOURTH:
                return new LottoResult(4, false);
            case THIRD:
                return new LottoResult(5, false);
            case SECOND:
                return new LottoResult(5, true);
            case FIRST:
                return new LottoResult(6, false);
        }
        return null;
    }

    public int rankToWinningMoney(Rank rank) {
        switch (rank) {
            case FIFTH:
                return 5000;
            case FOURTH:
                return 50000;
            case THIRD:
                return 1500000;
            case SECOND:
                return 30000000;
            case FIRST:
                return 2000000000;
        }
        return 0;
    }

}
