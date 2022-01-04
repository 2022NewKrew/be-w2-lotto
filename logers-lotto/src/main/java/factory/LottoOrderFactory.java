package factory;

import domain.LottoOrder;

public class LottoOrderFactory {
    public static LottoOrder createLottoOrder(int purchaseAmount){
        return new LottoOrder(purchaseAmount);
    }
}
