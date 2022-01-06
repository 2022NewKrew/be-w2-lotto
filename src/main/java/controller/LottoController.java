package controller;

import domain.match.WinningLottoNumber;
import domain.match.WinningLottoNumberDTO;
import domain.user.User;
import domain.match.LottoMatchStateDTO;
import domain.lotto.LottoNumberContainerDTO;
import repository.Repository;
import service.LottoService;

public class LottoController {
    private final Repository repository;
    private final LottoService lottoService;

    public LottoController(Repository repository, LottoService lottoService) {
        this.repository = repository;
        this.lottoService = lottoService;
    }

    public void saveUserBudget(User user, int money) {
        lottoService.increaseUserMoney(user, money);
    }

    public int getBuyLottoNumber(User user) {
        return lottoService.getBuyLottoNumber(user);
    }

    public LottoMatchStateDTO result(User user) {
        return lottoService.result(user);
    }

    public void setWinningLottoNumber(WinningLottoNumber winningLottoNumber) {
        lottoService.setWinningLottoNumber(winningLottoNumber);
    }
    public void setWinningLottoNumber(WinningLottoNumberDTO winningLottoNumberDTO) {
        lottoService.setWinningLottoNumber(winningLottoNumberDTO);
    }
    public void buyRandomLottos(User user, int buyNumber) throws Exception {
        lottoService.buyRandomLottos(user, buyNumber);
    }

    public void addManualLottosToUser(User user, LottoNumberContainerDTO askUserManualLottoNumbers) throws Exception {
        lottoService.addManualLottosToUser(user, askUserManualLottoNumbers);


    }
    public LottoNumberContainerDTO getUserLottos(User user) {
        return lottoService.getUserLottos(user);
    }
}
