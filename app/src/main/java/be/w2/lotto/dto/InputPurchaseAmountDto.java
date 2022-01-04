package be.w2.lotto.dto;

import be.w2.lotto.domain.LottoTickets;

public class InputPurchaseAmountDto {
    public LottoTickets lottoTickets;
    public int purchaseAmount;

    InputPurchaseAmountDto(LottoTickets lottoTickets, int purchaseAmount) {
        this.lottoTickets = lottoTickets;
        this.purchaseAmount = purchaseAmount;
    }

    public static InputPurchaseAmountDto of(LottoTickets lottoTickets, int purchaseAmount) {
        return new InputPurchaseAmountDto(lottoTickets, purchaseAmount);
    }
}
