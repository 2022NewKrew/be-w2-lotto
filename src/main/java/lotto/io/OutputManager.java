package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.PurchaseInfo;
import lotto.domain.WinningInfo;

import java.util.List;

public interface OutputManager {
    String LINE_BREAK = "\n";

    String printPurchaseInfo(PurchaseInfo purchaseInfo, List<Lotto> lottoList);
    String printPrizes(PurchaseInfo purchaseInfo, WinningInfo winningInfo);
}
