package lotto.io;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Scanner;

public interface InputManager {
    int getPurchaseAmount(Scanner scanner);
    int getManualLottoCount(Scanner scanner);
    List<Lotto> getManualLotto(Scanner scanner, int count);
    List<Integer> getWinningNumber(Scanner scanner);
    int getBonusNumber(Scanner scanner);
}
