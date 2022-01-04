package service;

import dto.LastWeekWinningNumberDTO;
import dto.LottoResultDTO;
import dto.PurchasingSheetDTO;

import java.util.List;

public interface LottoService {
    Long purchaseLotto(PurchasingSheetDTO purchasingSheetDTO);

    String getPurchasedLottoBundleString(Long lottoBundleId);

    LottoResultDTO getLottoResultDTO(LastWeekWinningNumberDTO winningNumbers, Long lottoBundleId);
}
