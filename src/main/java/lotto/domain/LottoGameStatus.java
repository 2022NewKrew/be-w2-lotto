package lotto.domain;

import java.util.List;

public class LottoGameStatus {

    private final int purchasePrice;
    private final List<Lotto> lottoTickets;

    public LottoGameStatus(int purchasePrice, List<Lotto> lottoTickets) {
        this.purchasePrice = purchasePrice;
        this.lottoTickets = lottoTickets;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
