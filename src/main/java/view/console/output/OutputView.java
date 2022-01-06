package view.console.output;

import dto.LastWeekWinningNumber;

public interface OutputView {
    void showPurchasedLottoBundle(Long lottoBundleId);

    void showPurchasedLottoResults(LastWeekWinningNumber lastWeekWinningNumberDTO, Long lottoBundleId);
}
