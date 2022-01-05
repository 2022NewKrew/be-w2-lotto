package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchaseManager {
    public List<Lotto> purchase(PurchaseInfo pi, List<Lotto> manualLottoList) {
        List<Lotto> result = new ArrayList<>(manualLottoList);
        for (int i = 0; i < pi.getNumOfPurchase(); i++) {
            result.add(LottoGenerator.generateRandomLotto());
        }
        return Collections.unmodifiableList(result);
    }
}
