package controller;

import domain.match.WinningLottoNumber;
import domain.user.User;
import repository.MemoryRepository;
import repository.Repository;
import service.LottoService;
import view.ConsoleLottoUI;
import view.LottoUI;

public class ConsoleAppStarter implements AppStarter {
    private final User user;
    private final LottoUI lottoUI;
    private final LottoController lottoController;

    public ConsoleAppStarter(LottoController controller, User user) {
        this.user = user;
        this.lottoUI = new ConsoleLottoUI();
        this.lottoController = controller;
    }

    public void run() throws Exception {
        lottoController.saveUserBudget(user, lottoUI.askUserBudget());

        int buyNum = lottoController.getBuyLottoNumber(user);
        int buyManualLottoNumber = lottoUI.askUserHowManyManualNumberLotto(buyNum);
        lottoController.addManualLottosToUser(user, lottoUI.askUserManualLottoNumbers(buyManualLottoNumber));

        lottoController.buyRandomLottos(user, buyNum - buyManualLottoNumber);
        lottoUI.showBoughtLottos(buyManualLottoNumber, buyNum-buyManualLottoNumber , user.getOwnedLottoTicketsDTO());

        lottoController.setWinningLottoNumber(new WinningLottoNumber(lottoUI.askUserWinningNumbers()));
        lottoUI.showResult(lottoController.result(user));
    }
}
