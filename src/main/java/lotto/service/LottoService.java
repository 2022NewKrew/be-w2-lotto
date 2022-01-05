package lotto.service;

import lotto.domain.AutoIssuingLottoMachine;
import lotto.domain.component.LottoNumber;
import lotto.domain.component.LottoTicket;
import lotto.domain.component.WinningLottoTicket;
import lotto.domain.result.LottoResult;
import lotto.dto.GetLottoResultDTO;

import java.util.List;


public class LottoService {

    private final AutoIssuingLottoMachine lottoMachine = new AutoIssuingLottoMachine();

    public List<LottoTicket> issueAutoLotto(int lottoPrice) {
        return lottoMachine.makeLottoTicket(lottoPrice);
    }

    public WinningLottoTicket issueWinningLotto(LottoTicket winningNumber, LottoNumber bonusBall) {
        return new WinningLottoTicket(winningNumber, bonusBall);
    }

    public LottoResult getLottoResult(GetLottoResultDTO getLottoResultDTO) {
        return new LottoResult(getLottoResultDTO);
    }
}
