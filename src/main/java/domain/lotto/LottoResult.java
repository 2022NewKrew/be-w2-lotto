package domain.lotto;

import domain.prize.Prize;

public class LottoResult {

    private final Prize lottoPrize;

    public LottoResult(int matchedNum, boolean bonusMatched) {
        this.lottoPrize = getPrizeByMatchedResult(matchedNum, bonusMatched);
    }

    private Prize getPrizeByMatchedResult(int matchedNum, boolean bonusMatched) {
        return Prize.valueOf(matchedNum, bonusMatched);
    }

    public Prize getPrizeType() {
        return lottoPrize;
    }

    public int getPrizeMoney() {
        return lottoPrize.getPrizeMoney();
    }

}
