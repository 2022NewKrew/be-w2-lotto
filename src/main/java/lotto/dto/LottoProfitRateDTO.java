package lotto.dto;

import lotto.domain.game.LottoProfitRate;

public class LottoProfitRateDTO {

    private final double profitRate;

    public static LottoProfitRateDTO from(LottoProfitRate lottoProfitRate) {
        return new LottoProfitRateDTO(lottoProfitRate.getProfitRate());
    }

    private LottoProfitRateDTO(double profitRate) {
        this.profitRate = profitRate;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
