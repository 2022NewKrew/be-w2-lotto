package lotto.domain.game;

import lotto.domain.model.LottoTickets;

public class LottoGameStatus {

    private final LottoTickets lottoTickets;
    private final LottoPurchasePrice lottoPurchasePrice;

    public static LottoGameStatus of(LottoTickets lottoTickets,
        LottoPurchasePrice lottoPurchasePrice) {
        return new LottoGameStatus(lottoTickets, lottoPurchasePrice);
    }

    private LottoGameStatus(LottoTickets lottoTickets, LottoPurchasePrice lottoPurchasePrice) {
        this.lottoTickets = lottoTickets;
        this.lottoPurchasePrice = lottoPurchasePrice;
    }

    public LottoPurchasePrice getPurchasePrice() {
        return lottoPurchasePrice;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
