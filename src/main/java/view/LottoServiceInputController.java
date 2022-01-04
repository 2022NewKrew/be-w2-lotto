package view;

import java.util.List;

public interface LottoServiceInputController {
    int getPurchaseAmount();
    int getNumberOfManualPurchase();
    List<Integer> getManualLottoNumber();
    List<Integer> getLastWeekWinningNumbers();
    int getBonusBallNumber();
}
