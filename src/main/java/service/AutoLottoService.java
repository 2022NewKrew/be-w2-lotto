package service;

import repository.LottoRepository;
import repository.Repository;
import service.lotto.LottoBundle;
import service.lotto.LottoStore;

public class AutoLottoService implements LottoService {
    private final Repository repository = new LottoRepository();

    @Override
    public Long purchaseLotto(int quantity) {
        LottoStore lottoStore = new LottoStore();
        LottoBundle lottoBundle = lottoStore.purchaseLotto(quantity);
        repository.save(lottoBundle);
        return lottoBundle.getId();
    }

    @Override
    public String getPurchasedLottoBundleString(Long lottoBundleId) {
        return repository.getLottoBundle(lottoBundleId).toString();
    }
}
