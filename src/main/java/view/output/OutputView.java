package view.output;

import dto.LastWeekWinningNumberDTO;

import java.util.List;

public interface OutputView {
    void showPurchasedLottoBundle(Long lottoBundleId);

    void showPurchasedLottoResults(LastWeekWinningNumberDTO lastWeekWinningNumberDTO, Long lottoBundleId);
}
