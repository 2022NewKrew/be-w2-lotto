package lotto.domain.game;

public class LottoProfitRate {

    private final double profitRate;

    public static LottoProfitRate of(int totalPrizeMoney, LottoPurchasePrice lottoPurchasePrice) {
        return new LottoProfitRate(lottoPurchasePrice.calculateProfitRate(totalPrizeMoney));
    }

    private LottoProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
