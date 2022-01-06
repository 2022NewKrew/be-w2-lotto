package lotto.view;

import java.util.List;

public interface InputView {
    int getInputPrice();
    int getManualTicketCount();
    List<String[]> getManualLottoNumbers(int manualTicketCount);
    String[] getWinningNumbers();
    int getBonusNumber();
}
