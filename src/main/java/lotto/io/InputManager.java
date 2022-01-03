package lotto.io;

import lotto.domain.PurchaseInfo;

import java.util.List;
import java.util.Scanner;

public interface InputManager {
    PurchaseInfo getPurchaseAmount(Scanner scanner);
    List<Integer> getWinningNumber(Scanner scanner);
}
