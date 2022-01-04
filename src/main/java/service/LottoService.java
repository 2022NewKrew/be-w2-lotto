package service;

import dto.LastWeekWinningNumberDTO;
import dto.LottoResultDTO;

import java.util.List;

public interface LottoService {
    Long purchaseLotto(int quantity);

    String getPurchasedLottoBundleString(Long lottoBundleId);

    LottoResultDTO getLottoResultDTO(LastWeekWinningNumberDTO winningNumbers, Long lottoBundleId);
}
