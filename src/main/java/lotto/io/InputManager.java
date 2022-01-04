package lotto.io;

import java.util.List;
import java.util.Scanner;

public interface InputManager {
    int getPurchaseAmount(Scanner scanner);
    List<Integer> getWinningNumber(Scanner scanner);
    int getBonusNumber(Scanner scanner);
}
