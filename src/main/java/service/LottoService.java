package service;

import dto.LastWeekWinningNumber;
import dto.LottoResultDTO;
import dto.PurchasingSheet;
import service.lotto.LottoBundle;

public interface LottoService {
    Long purchaseLotto(PurchasingSheet purchasingSheet);

    LottoBundle getPurchasedLottoBundle(Long lottoBundleId);

    LottoResultDTO getLottoResult(LastWeekWinningNumber winningNumbers, Long lottoBundleId);
}
