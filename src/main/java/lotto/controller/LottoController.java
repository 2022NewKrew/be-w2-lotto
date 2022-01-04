package lotto.controller;

import lotto.domain.component.LottoNumber;
import lotto.domain.component.LottoPrice;
import lotto.domain.component.LottoTicket;
import lotto.domain.component.WinningLottoTicket;
import lotto.domain.result.LottoResult;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public List<LottoTicket> purchaseLotto(LottoPrice lottoPrice){
        return lottoService.purchaseLotto(lottoPrice);
    }

    public WinningLottoTicket issueWinningLotto(LottoTicket winningNumber, LottoNumber bonusBall){
        return lottoService.issueWinningLotto(winningNumber,bonusBall);
    }

    public LottoResult getLottoResult(WinningLottoTicket winningLottoTicket,List<LottoTicket> lottoTickets,int lottoPrice){
        return lottoService.getLottoResult(winningLottoTicket,lottoTickets,lottoPrice);
    }
}
