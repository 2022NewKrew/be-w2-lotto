package step2.controller;

import step2.domain.LottoConfig;
import step2.domain.WinningLotto;
import step2.dto.LottoResultDto;
import step2.dto.LottoSheetDto;

public interface LottoController {

    LottoSheetDto purchase(LottoConfig lottoConfig);
    LottoResultDto checkLottoeryResult(WinningLotto winningLotto, Long userId);
}
