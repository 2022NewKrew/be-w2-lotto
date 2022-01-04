package view;

import dto.LottoMatchStateDTO;
import dto.LottoNumberContainerDTO;
import dto.LottoNumberDTO;
import dto.WinningLottoNumberDTO;

public interface LottoUI {
    int askUserBudget();
    int askUserHowManyManualNumberLotto(int buyLimitNum);
    LottoNumberContainerDTO askUserManualLottoNumbers(int num);
    void showBoughtLottos(String message, LottoNumberContainerDTO lottoNumberContainerDTO);
    WinningLottoNumberDTO askUserWinningNumbers();
    int askUserExtraBounusNumber();
    void showResult(LottoMatchStateDTO lottoMatchStateDTO);
}
