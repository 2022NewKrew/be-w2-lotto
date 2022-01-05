package step2.controller;

import step2.domain.LottoConfig;
import step2.domain.WinningLotto;
import step2.dto.LottoResultDto;
import step2.dto.LottoSheetDto;

public interface LottoController {

    <T extends LottoConfig> LottoSheetDto purchase(T lottoConfig);
    LottoResultDto checkLotteryResult(WinningLotto winningLotto, Long userId);
}
