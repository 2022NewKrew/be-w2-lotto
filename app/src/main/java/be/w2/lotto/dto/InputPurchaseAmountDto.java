package be.w2.lotto.dto;

import be.w2.lotto.domain.lottoticket.LottoTickets;

public class InputPurchaseAmountDto {
    public LottoTickets lottoTickets;
    public int purchaseAmount;
    public int manualPurchaseAmount;

    InputPurchaseAmountDto(LottoTickets lottoTickets, int purchaseAmount, int manualPurchaseAmount) {
        this.lottoTickets = lottoTickets;
        this.purchaseAmount = purchaseAmount;
        this.manualPurchaseAmount = manualPurchaseAmount;
    }

    public static InputPurchaseAmountDto of(LottoTickets lottoTickets, int purchaseAmount, int manualPurchaseAmount) {
        return new InputPurchaseAmountDto(lottoTickets, purchaseAmount, manualPurchaseAmount);
    }
}
