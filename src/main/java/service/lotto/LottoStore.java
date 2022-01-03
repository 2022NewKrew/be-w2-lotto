package service.lotto;

import java.util.ArrayList;

public class LottoStore {
    public LottoBundle purchaseLotto(int quantity){
        LottoBundle lottoBundle = new LottoBundle(new ArrayList<>());
        for (int i = 0; i < quantity; i++){
            lottoBundle.getLottoBundle().add(LottoGenerator.generateLotto());
        }
        return lottoBundle;
    }
}
