package service;

import dto.LastWeekWinningNumber;
import dto.LottoResult;
import dto.PurchasingSheet;

public interface LottoService {
    Long purchaseLotto(PurchasingSheet purchasingSheet);

    String getPurchasedLottoBundleString(Long lottoBundleId);

    LottoResult getLottoResultDTO(LastWeekWinningNumber winningNumbers, Long lottoBundleId);
}
