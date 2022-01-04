package domain.lotto;

import domain.prize.Prize;


import static domain.prize.Prize.*;

public class LottoResult {

    private Prize lottoPrize;

    public LottoResult(int matchedNum) {
        switch (matchedNum) {
            case FIRST_PRIZE_COUNT:
                lottoPrize = FIRST_PRIZE;
                break;
            case SECOND_PRIZE_COUNT:
                lottoPrize = SECOND_PRIZE;
                break;
            case THIRD_PRIZE_COUNT:
                lottoPrize = THIRD_PRIZE;
                break;
            case FOURTH_PRIZE_COUNT:
                lottoPrize = FOURTH_PRIZE;
                break;
            case FIFTH_PRIZE_COUNT:
                lottoPrize = FIFTH_PRIZE;
                break;
            default:
                lottoPrize = NO_PRIZE;
        }
    }

    public Prize getPrizeType() {
        return lottoPrize;
    }

    public int getPrizeMoney() {
        return lottoPrize.getPrizeMoney();
    }

    public int getMatchedNum() {
        return lottoPrize.getMatchedNum();
    }
}
