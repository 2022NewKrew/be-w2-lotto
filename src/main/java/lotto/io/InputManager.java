package lotto.io;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Scanner;

public interface InputManager {
    int getPurchaseAmount(String string);
    int getManualLottoCount(String string);
    Lotto getManualLotto(String string);
    List<Integer> getWinningNumber(String string);
    int getBonusNumber(String string);
}
