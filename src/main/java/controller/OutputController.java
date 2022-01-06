package controller;

import dto.LastWeekWinningNumber;

public interface OutputController {

    String showPurchasedLottoBundle(Long lottoBundleId);

    String showPurchasedLottoResults(LastWeekWinningNumber lastWeekWinningNumberDTO, Long lottoBundleId);
}
