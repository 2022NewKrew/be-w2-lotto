package lotto.io;

import lotto.domain.Lotto;

import java.util.List;

public interface InputManager<T> {
    int getPurchaseAmount(T t);
    int getManualLottoCount(T t, int totalNumOfPurchase);
    List<Lotto> getManualLotto(T t, int manualLottoCount);
    List<Integer> getWinningNumber(T t);
    int getBonusNumber(T t, List<Integer> winningNumber);
}
