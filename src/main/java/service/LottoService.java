package service;

import domain.lotto.LottoNumber;
import domain.match.*;
import domain.user.User;
import domain.lotto.LottoNumberContainerDTO;
import repository.Repository;

public class LottoService {
    private WinningLottoNumber winningLottoNumber;
    public void initRepository(Repository repository, Long userId) {
        repository.init(userId);
    }

    public void increaseUserMoney(User user, int money) {
        user.increaseOwnedMoney(money);
    }

    public int getBuyLottoNumber(User user) {
        int totalNumOfLottos = (user.getOwnedMoney() / LottoNumber.LOTTO_UNIT_PRICE);
        user.increaseCostedMoney(totalNumOfLottos * LottoNumber.LOTTO_UNIT_PRICE);
        return totalNumOfLottos;
    }

    public void buyRandomLottos(User user, int buyNumber) throws Exception {
        for(int i = 0; i< (buyNumber);i++){
            user.addOneLotto(LottoNumber.randomLottoNumberFactory());
        }
    }

    public void setWinningLottoNumber(WinningLottoNumber winningLottoNumber) {
        this.winningLottoNumber = winningLottoNumber;
    }
    public void setWinningLottoNumber(WinningLottoNumberDTO winningLottoNumberDTO) {
        this.winningLottoNumber = new WinningLottoNumber(winningLottoNumberDTO);
    }


    public LottoMatchStateDTO result(User user) {
        // LottoMatchStateDTO를 만든다.
        LottoMatchStateDTO lottoMatchStateDTO = new LottoMatchStateDTO(LottoRank.getNumOfRanks());
        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator(winningLottoNumber);
        // DTO 상태를 만든다.
        lottoMatchStateDTO.setMoneyTotalCost(user.getCostedMoney());
        LottoRank rank;
        user.getOwnedLottoTicketsDTO();
        user.getLottoNumbersContainer();
        for (LottoNumber lottoNumber : user.getLottoNumbersContainer()) {
            rank = lottoRankCalculator.calculator(lottoNumber);
            lottoMatchStateDTO.addMatch(rank);
            lottoMatchStateDTO.addMoneyTotalWin(rank.getPrize());
        }
        return lottoMatchStateDTO;

    }

    public void addManualLottosToUser(User user, LottoNumberContainerDTO dto) throws Exception{
        user.addLottosByDTO(dto);
    }

    public LottoNumberContainerDTO getUserLottos(User user) {
        return user.getOwnedLottoTicketsDTO();
    }
}
