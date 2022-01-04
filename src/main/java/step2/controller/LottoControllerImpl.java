package step2.controller;

import step2.domain.LottoConfig;
import step2.domain.service.LottoSheetIssuer;
import step2.domain.WinningLotto;
import step2.domain.service.LottoResultGenerator;
import step2.domain.LottoSheetWithId;
import step2.dto.LottoResultDto;
import step2.dto.LottoSheetDto;
import step2.repository.LottoSheetRepository;

public class LottoControllerImpl implements LottoController{

    private final LottoSheetIssuer lottoSheetIssuer;
    private final LottoSheetRepository lottoSheetRepository;
    private final LottoResultGenerator lottoResultGenerator;

    public LottoControllerImpl(LottoSheetIssuer lottoSheetIssuer, LottoSheetRepository lottoSheetRepository, LottoResultGenerator lottoResultGenerator) {
        this.lottoSheetIssuer = lottoSheetIssuer;
        this.lottoSheetRepository = lottoSheetRepository;
        this.lottoResultGenerator = lottoResultGenerator;
    }

    @Override
    public LottoSheetDto purchase(LottoConfig lottoConfig) {
        LottoSheetWithId lottoSheet = lottoSheetIssuer.issueLottoSheet(lottoConfig);
        return LottoSheetDto.of(lottoSheet);
    }

    @Override
    public LottoResultDto checkLotteryResult(WinningLotto winningLotto, Long userId) {
        LottoSheetWithId lottoSheetWithId = lottoSheetRepository.findByUserId(userId);
        LottoResultDto lottoResultDto = lottoResultGenerator.makeLottoResult(winningLotto, lottoSheetWithId);
        return lottoResultDto;
    }
}
