package domain.result;

import java.util.HashMap;
import java.util.Map;

public enum Winning {
    FIRST_WINNING(6, 2000000000), //1등
    SECOND_WINNING(5, 1500000), //2등
    THIRD_WINNING(4, 50000), //3등
    FOURTH_WINNING(3, 5000), //4등
    FIFTH_WINNING(2, 0), //5등
    SIXTH_WINNING(1, 0), //6등
    SEVENTH_WINNING(0, 0); //7등

    private static final Map<Integer, Integer> HITTING_PRICE;

    static {
        HITTING_PRICE = new HashMap<>();

        for(Winning e : values()) {
            HITTING_PRICE.put(e.hittingCnt, e.winningPrice);
        }
    }

    private final int hittingCnt;
    private final int winningPrice;


    Winning(int hittingCnt, int winningPrice) {
        this.hittingCnt = hittingCnt;
        this.winningPrice = winningPrice;
    }

    public static int priceOfHitting(int hittingCnt) {
        return HITTING_PRICE.get(hittingCnt);
    }

    public int getHittingCnt() {
        return hittingCnt;
    }
}
