package dto.output;

import domain.LottoOrder;

public class PurchaseResultDto {
    private final LottoOrder lottoOrder;

    public PurchaseResultDto(LottoOrder lottoOrder) {
        this.lottoOrder = lottoOrder;
    }

    @Override
    public String toString() {
        return lottoOrder.toString();
    }
}
