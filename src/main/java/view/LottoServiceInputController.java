package view;

import java.util.InputMismatchException;
import java.util.List;

public interface LottoServiceInputController {
    int getPurchaseAmount() throws InputMismatchException, IllegalArgumentException;
    List<Integer> getLastWeekWinningNumber() throws InputMismatchException, IllegalArgumentException;
}
