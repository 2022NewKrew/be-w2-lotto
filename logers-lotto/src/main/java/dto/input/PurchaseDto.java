package dto.input;

<<<<<<< HEAD
public class PurchaseDto {
    private final int purchaseAmount;

    public PurchaseDto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
=======
import domain.LottoOrder;
import factory.LottoOrderFactory;

public class PurchaseDto {
    private final int purchaseAmount;
    private final LottoOrder lottoOrder;

    public PurchaseDto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottoOrder = LottoOrderFactory.createLottoOrder(purchaseAmount);
>>>>>>> a030324 (refactor : 구조개선)
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
<<<<<<< HEAD
=======

    public LottoOrder getLottoOrder() {
        return lottoOrder;
    }
>>>>>>> a030324 (refactor : 구조개선)
}
