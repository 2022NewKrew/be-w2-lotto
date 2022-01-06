package domain.result;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Winning {
    FIRST_WINNING(1, 6,  2_000_000_000),
    SECOND_WINNING(2, 5,  1_500_000),
    THIRD_WINNING(3, 5,  1_500_000),
    FOURTH_WINNING(4, 4,  50_000),
    FIFTH_WINNING(5, 3,  5_000),
    SIXTH_WINNING(6, 2,  0),
    SEVENTH_WINNING(7, 1,  0),
    EIGHTH_WINNING(8, 0,  0);

    private static final Map<Integer, Integer> RANK_PRICE;
    private static final Map<Integer, Integer> RANK_HITTING;

    static {
        RANK_PRICE = new HashMap<>();
        RANK_HITTING = new HashMap<>();

        for (Winning e : values()) {
            RANK_PRICE.put(e.rank, e.winningPrice);
            RANK_HITTING.put(e.rank, e.hittingCnt);
        }
    }

    private final int rank;
    private final int hittingCnt;
    private final int winningPrice;

    Winning(int rank, int hittingCnt, int winningPrice) {
        this.rank = rank;
        this.hittingCnt = hittingCnt;
        this.winningPrice = winningPrice;
    }

    public static int priceOfRank(int rank) {
        return RANK_PRICE.get(rank);
    }

    public static int hittingCntOfRank(int rank) {
        return RANK_HITTING.get(rank);
    }

    public static int rankOfHitting(int hittingCnt, int bonusCnt) {
        int rank = Arrays.stream(values())
                .filter(e -> e.hittingCnt == hittingCnt)
                .map(e -> e.rank)
                .findFirst()
                .get();
        if (rank == THIRD_WINNING.rank && bonusCnt == 1) {
            return SECOND_WINNING.rank;
        }

        if (rank > SIXTH_WINNING.rank) {
            return SIXTH_WINNING.rank;
        }
        return rank;
    }

    public int getRank() {
        return rank;
    }

}
