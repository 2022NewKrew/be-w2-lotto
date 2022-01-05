package service.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoStore {
    public LottoBundle purchaseLotto(int quantity, List<List<Integer>> manualLottoNumbers) {
        LottoBundle lottoBundle = new LottoBundle(new ArrayList<>());
        purchaseLottoManually(manualLottoNumbers, lottoBundle);
        purchaseLottoAutomatically(quantity, lottoBundle);
        return lottoBundle;
    }

    private void purchaseLottoAutomatically(int quantity, LottoBundle lottoBundle) {
        IntStream.range(0, quantity)
                .forEach(i ->
                        lottoBundle.getLottoBundle().add(LottoGenerator.autoGenerateLotto())
                );
    }

    private void purchaseLottoManually(List<List<Integer>> manualLottoNumbers, LottoBundle lottoBundle) {
        manualLottoNumbers
                .forEach(manualLottoNumber ->
                        lottoBundle.getLottoBundle()
                                .add(LottoGenerator.manualGenerateLotto(manualLottoNumber)));
    }
}
