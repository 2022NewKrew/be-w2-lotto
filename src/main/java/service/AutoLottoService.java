package service;

import dto.LastWeekWinningNumberDTO;
import dto.LottoResultDTO;
import dto.PurchasingSheetDTO;
import repository.LottoRepository;
import repository.Repository;
import service.lotto.LottoBundle;
import service.lotto.LottoStore;

public class AutoLottoService implements LottoService {
    private final Repository repository = new LottoRepository();

    @Override
    public Long purchaseLotto(PurchasingSheetDTO purchasingSheetDTO) {
        LottoStore lottoStore = new LottoStore();
        LottoBundle lottoBundle = lottoStore.purchaseLotto(purchasingSheetDTO.getAutoLottoAmount(), purchasingSheetDTO.getManualLottoNumber());
        repository.save(lottoBundle);
        return lottoBundle.getId();
    }

    @Override
    public String getPurchasedLottoBundleString(Long lottoBundleId) {
        return repository.getLottoBundle(lottoBundleId).toString();
    }

    @Override
    public LottoResultDTO getLottoResultDTO(LastWeekWinningNumberDTO lastWeekWinningNumberDTO, Long lottoBundleId) {
        LottoBundle lottoBundle = repository.getLottoBundle(lottoBundleId);
        lottoBundle.confirmTheWin(lastWeekWinningNumberDTO.getLastWeekWinningNumber(), lastWeekWinningNumberDTO.getBonusNumber());
        return LottoResultDTO.of(lottoBundle);
    }
}
