package step2.domain.service;

import step2.domain.LottoSheetWithId;
import step2.domain.WinningLotto;
import step2.dto.LottoResultDto;

public interface LottoResultGenerator<T extends LottoSheetWithId> {
    LottoResultDto makeLottoResult(WinningLotto winningLotto, T lottoSheet);
}
