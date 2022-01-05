package view.dto;

import domain.LottoTickets;

import java.util.List;

public class LottoPurchaseResponse {

    private final LottoTickets lottoTickets;

    private final int manualLottoCount;

    public LottoPurchaseResponse(LottoTickets lottoTickets, int manualLottoCount) {
        this.lottoTickets = lottoTickets;
        this.manualLottoCount = manualLottoCount;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }
}
