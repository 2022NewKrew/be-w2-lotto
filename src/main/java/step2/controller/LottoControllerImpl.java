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

    // 구매 정보로 로또 발급 및 반환
    @Override
    public LottoSheetDto purchase(LottoConfig lottoConfig) {
        LottoSheetWithId lottoSheet = lottoSheetIssuer.issueLottoSheet(lottoConfig);
        return LottoSheetDto.of(lottoSheet);
    }

    // 당첨 번호로 결과 반환
    @Override
    public LottoResultDto checkLotteryResult(WinningLotto winningLotto, Long userId) {
        // Repository에서 userId의 LottoSheet를 가져온다
        LottoSheetWithId lottoSheetWithId = lottoSheetRepository.findByUserId(userId);
        // LottoResultGenerator(결과 계산)에 winningLotto(당첨 정보)와 LottoSheet 보내 결과를 받는다
        LottoResultDto lottoResultDto = lottoResultGenerator.makeLottoResult(winningLotto, lottoSheetWithId);
        return lottoResultDto;
    }
}
