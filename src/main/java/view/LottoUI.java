package view;

import domain.match.LottoMatchStateDTO;
import domain.lotto.LottoNumberContainerDTO;
import domain.match.WinningLottoNumberDTO;

public interface LottoUI {
    int askUserBudget();
    int askUserHowManyManualNumberLotto(int buyLimitNum);
    LottoNumberContainerDTO askUserManualLottoNumbers(int num);
    void showBoughtLottos(int manualLottosNum, int randomLottosNum, LottoNumberContainerDTO lottoNumberContainerDTO);
    WinningLottoNumberDTO askUserWinningNumbers();
    void showResult(LottoMatchStateDTO lottoMatchStateDTO);
}
