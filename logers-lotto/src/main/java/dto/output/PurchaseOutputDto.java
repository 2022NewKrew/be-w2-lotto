package dto.output;

import domain.LottoOrder;

public class PurchaseOutputDto {
    private final LottoOrder lottoOrder;

    public PurchaseOutputDto(LottoOrder lottoOrder) {
        this.lottoOrder = lottoOrder;
    }

    @Override
    public String toString() {
        return lottoOrder.toString();
    }
}
