package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.component.LottoNumber;
import lotto.domain.component.LottoPrice;
import lotto.domain.component.LottoTicket;
import lotto.domain.component.WinningLottoTicket;
import lotto.domain.result.LottoResult;

import java.util.List;


public class LottoService {

    private final LottoMachine lottoMachine = new LottoMachine();

    public List<LottoTicket> purchaseLotto(LottoPrice lottoPrice){
        return lottoMachine.makeLottoTicket(lottoPrice);
    }

    public WinningLottoTicket issueWinningLotto(LottoTicket winningNumber, LottoNumber bonusBall){
        return new WinningLottoTicket(winningNumber,bonusBall);
    }

    public LottoResult getLottoResult(WinningLottoTicket winningLottoTicket,List<LottoTicket> lottoTickets,int lottoPrice){
        return new LottoResult(winningLottoTicket,lottoTickets,lottoPrice);
    }
}
