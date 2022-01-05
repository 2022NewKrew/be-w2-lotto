package lotto.domain.game;

public class LottoGameResult {

    private final LottoRankCount lottoRankCount;
    private final LottoProfitRate lottoProfitRate;

    public static LottoGameResult of(LottoRankCount lottoRankCount,
        LottoPurchasePrice lottoPurchasePrice) {
        return new LottoGameResult(lottoRankCount, lottoPurchasePrice);
    }

    private LottoGameResult(LottoRankCount lottoRankCount, LottoPurchasePrice lottoPurchasePrice) {
        this.lottoRankCount = lottoRankCount;

        lottoProfitRate = LottoProfitRate.of((int) lottoRankCount.calculateTotalPrizeMoney(),
            lottoPurchasePrice);
    }

    public LottoRankCount getLottoRankCount() {
        return lottoRankCount;
    }

    public LottoProfitRate getLottoProfitRate() {
        return lottoProfitRate;
    }
}
