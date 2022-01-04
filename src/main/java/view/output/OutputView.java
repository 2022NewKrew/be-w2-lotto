package view.output;

import java.util.List;

public interface OutputView {
    void showPurchasedLottoBundle(Long lottoBundleId);

    void showPurchasedLottoResults(List<Integer> winningNumbers, Long lottoBundleId);
}
