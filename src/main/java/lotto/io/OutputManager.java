package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.PurchaseInfo;
import lotto.domain.WinningInfo;

import java.util.List;

public interface OutputManager {
    void printPurchaseInfo(PurchaseInfo purchaseInfo);
    void printAllLotto(List<Lotto> lottoList);
    void printPrizes(PurchaseInfo purchaseInfo, WinningInfo winningInfo);
}
