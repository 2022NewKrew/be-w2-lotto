package view.input;

import java.util.List;

public interface InputInterface {
    void openScanner();
    void closeScanner();

    int inputBudget() throws Exception;
    List<Integer> inputWinningNumbers() throws Exception;
}
