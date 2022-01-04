package domain.lotto;

import domain.prize.Prize;

import static domain.prize.Prize.*;

public class LottoResult {

    private final Prize lottoPrize;

    public LottoResult(int matchedNum, boolean bonusMatched) {
        lottoPrize = getPrizeByMatchedResult(matchedNum, bonusMatched);
    }

    private Prize getPrizeByMatchedResult(int matchedNum, boolean bonusMatched) {
        if (matchedNum == FIRST_PRIZE_COUNT) {
            return FIRST_PRIZE;
        }
        if (matchedNum == SECOND_PRIZE_COUNT && bonusMatched) {
            return SECOND_PRIZE;
        }
        if (matchedNum == THIRD_PRIZE_COUNT) {
            return THIRD_PRIZE;
        }
        if (matchedNum == FOURTH_PRIZE_COUNT) {
            return FOURTH_PRIZE;
        }
        if (matchedNum == FIFTH_PRIZE_COUNT) {
            return FIFTH_PRIZE;
        }
        return NO_PRIZE;
    }

    public Prize getPrizeType() {
        return lottoPrize;
    }

    public int getPrizeMoney() {
        return lottoPrize.getPrizeMoney();
    }

}
