package lotto.controller;

import lotto.domain.component.LottoNumber;
import lotto.domain.component.LottoTicket;
import lotto.domain.component.WinningLottoTicket;
import lotto.domain.result.LottoResult;
import lotto.dto.GetLottoResultDTO;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public List<LottoTicket> issueAutoLotto(int numberOfAutoLotto) {
        return lottoService.issueAutoLotto(numberOfAutoLotto);
    }

    public WinningLottoTicket issueWinningLotto(LottoTicket winningNumber, LottoNumber bonusBall) {
        return lottoService.issueWinningLotto(winningNumber, bonusBall);
    }

    public LottoResult getLottoResult(GetLottoResultDTO getLottoResultDTO) {
        return lottoService.getLottoResult(getLottoResultDTO);
    }
}
