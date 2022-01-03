package controller;

import domain.lotto.Lotto;
import service.LottoService;
import view.UserInput;
import view.UserOutput;

import java.util.List;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void run() {
        int money = UserInput.getMoney();
        UserOutput.printBuyMessage(money / Lotto.LOTTO_PRICE);
        lottoService.buyLottos(money);
        UserOutput.printLotto(lottoService.getLottoDTOs());
        List<Integer> winningNumbers = UserInput.getWinningLotto();
        lottoService.setWinningLotto(winningNumbers);
        UserOutput.printHistory(lottoService.getResult());
    }
}
