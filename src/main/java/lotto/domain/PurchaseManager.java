package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseManager {
    public List<Lotto> purchase(PurchaseInfo pi) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < pi.getNumOfPurchase(); i++) {
            result.add(new Lotto());
        }
        return result;
    }
}
