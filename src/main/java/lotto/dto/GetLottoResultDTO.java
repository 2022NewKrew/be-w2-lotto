package lotto.dto;

import lotto.domain.component.LottoTicket;
import lotto.domain.component.WinningLottoTicket;

import java.util.Collections;
import java.util.List;

public class GetLottoResultDTO {

    private WinningLottoTicket winningLottoTicket;
    private List<LottoTicket> lottoTickets;
    private int purchasePrice;

    public GetLottoResultDTO(WinningLottoTicket winningLottoTicket, List<LottoTicket> lottoTickets, int purchasePrice) {
        this.winningLottoTicket = winningLottoTicket;
        this.lottoTickets = lottoTickets;
        this.purchasePrice = purchasePrice;
    }

    public WinningLottoTicket getWinningLottoTicket() {
        return winningLottoTicket;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

}
