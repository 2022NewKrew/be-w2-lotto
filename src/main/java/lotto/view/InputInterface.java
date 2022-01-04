package lotto.view;

import java.util.List;

public interface InputInterface {
    long inputBudget();
    List<Integer> inputWinningNumbers();
    int inputBonusNumber(List<Integer> winningNumbers);
}
