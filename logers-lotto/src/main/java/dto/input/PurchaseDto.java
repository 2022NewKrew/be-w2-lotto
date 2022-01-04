package dto.input;

import domain.LottoOrder;
import factory.LottoOrderFactory;

public class PurchaseDto {
    private final int purchaseAmount;
    private final LottoOrder lottoOrder;

    public PurchaseDto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottoOrder = LottoOrderFactory.createLottoOrder(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public LottoOrder getLottoOrder() {
        return lottoOrder;
    }
}
