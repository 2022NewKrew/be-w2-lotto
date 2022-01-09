package domain;

public class LottoPack {
    private final LottoBundle lottoList;
    private static final int LOTTO_PRICE = 1000;
    private final int buyPrice;
    private final int manualCount;
    private final int autoCount;

    public int getBuyPrice() {
        return buyPrice;
    }

    public LottoPack(int buyPrice, int manualCount, LottoBundle lottoBundle) {
        this.buyPrice = buyPrice;
        this.autoCount = buyPrice / LOTTO_PRICE - manualCount;
        this.manualCount = manualCount;
        lottoList = lottoBundle;
    }

    public static int getAutoCount(int buyPrice, int manualCount) {
        return buyPrice / LOTTO_PRICE - manualCount;
    }

    public String printLottoPack() {
        return String.format("수동으로 %d장, 자동으로 %d 개를 구매했습니다.\n", manualCount, autoCount) +
                lottoList.printBundle();
    }

    public RankingPack makeRankingPack(Lotto winningLottoTicket, int bonus) {
        return new RankingPack(lottoList.makeRankingPack(winningLottoTicket, bonus));
    }


}
