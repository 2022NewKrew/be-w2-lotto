package service.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public LottoBundle purchaseLotto(int quantity, List<List<Integer>> manualLottoNumbers) {
        LottoBundle lottoBundle = new LottoBundle(new ArrayList<>());
        for (List<Integer> manualLottoNumber : manualLottoNumbers) {
            lottoBundle.getLottoBundle().add(LottoGenerator.manualGenerateLotto(manualLottoNumber));
        }
        for (int i = 0; i < quantity; i++) {
            lottoBundle.getLottoBundle().add(LottoGenerator.autoGenerateLotto());
        }
        return lottoBundle;
    }
}
