package factory;

import domain.LottoOrder;

import java.util.Optional;

public class LottoOrderFactory {
    private static LottoOrder instance = null;

    public static Optional<LottoOrder> getInstance(){
        return Optional.of(instance);
    }

    public static Optional<LottoOrder> getInstance(int purchaseAmount){
        if(instance != null){
            return Optional.empty();
        }

        instance = createLottoOrder(purchaseAmount);
        return Optional.of(instance);
    }

    private static LottoOrder createLottoOrder(int purchaseAmount){
        return new LottoOrder(purchaseAmount);
    }
}
