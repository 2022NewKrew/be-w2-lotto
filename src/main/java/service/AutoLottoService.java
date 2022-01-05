package service;

import dto.LastWeekWinningNumber;
import dto.LottoResult;
import dto.PurchasingSheet;
import repository.InMemoryLottoRepository;
import repository.Repository;
import service.lotto.LottoBundle;
import service.lotto.LottoStore;

public class AutoLottoService implements LottoService {
    private final Repository repository = new InMemoryLottoRepository();
    private final LottoStore lottoStore = new LottoStore();

    @Override
    public Long purchaseLotto(PurchasingSheet purchasingSheet) {
        LottoBundle lottoBundle = lottoStore.purchaseLotto(purchasingSheet.getAutoLottoAmount(), purchasingSheet.getManualLottoNumber());
        repository.save(lottoBundle);
        return lottoBundle.getId();
    }

    @Override
    public String getPurchasedLottoBundleString(Long lottoBundleId) {
        return repository.getLottoBundle(lottoBundleId).toString();
    }

    @Override
    public LottoResult getLottoResultDTO(LastWeekWinningNumber lastWeekWinningNumberDTO, Long lottoBundleId) {
        LottoBundle lottoBundle = repository.getLottoBundle(lottoBundleId);
        lottoBundle.confirmTheWin(lastWeekWinningNumberDTO.getLastWeekWinningNumber(), lastWeekWinningNumberDTO.getBonusNumber());
        return LottoResult.of(lottoBundle);
    }
}
