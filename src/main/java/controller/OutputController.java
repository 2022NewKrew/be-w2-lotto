package controller;

import dto.LastWeekWinningNumber;
import dto.LottoResult;

public interface OutputController {

    String showPurchasedLottoBundle(Long lottoBundleId);

    String showPurchasedLottoResults(LastWeekWinningNumber lastWeekWinningNumberDTO, Long lottoBundleId);
}
