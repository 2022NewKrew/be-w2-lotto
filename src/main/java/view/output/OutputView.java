package view.output;

import dto.LastWeekWinningNumberDTO;

public interface OutputView {
    void showPurchasedLottoBundle(Long lottoBundleId);

    void showPurchasedLottoResults(LastWeekWinningNumberDTO lastWeekWinningNumberDTO, Long lottoBundleId);
}
