package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {
    private static final int BASIC_PRICE = 1000;

    private List<Lotto> lottos;

    private PurchaseLotto(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static PurchaseLotto of(int purchasePrice) {
        validateLottos(purchasePrice);

        List<Lotto> lottos = new ArrayList<>();
        int purchaseCount = purchasePrice / BASIC_PRICE;

        for (int i = 0; i < purchaseCount; ++i) {
            lottos.add(Lotto.of());
        }

        return new PurchaseLotto(lottos);
    }

    private static void validateLottos(int purchasePrice) {
        if (purchasePrice < BASIC_PRICE) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_PRICE.getMessage());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
