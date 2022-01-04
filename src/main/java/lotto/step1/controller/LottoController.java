package lotto.step1.controller;

import lotto.step1.dto.request.ConfirmTheWinDTO;
import lotto.step1.dto.response.LottoResultsDTO;
import lotto.step1.dto.response.PurchasedLottoDTO;
import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.exception.NotFoundEntityException;
import lotto.step1.model.Lotto;
import lotto.step1.model.LottoGenerator;
import lotto.step1.repository.LottoRepository;

import java.util.List;

public class LottoController {
    protected final LottoGenerator lottoGenerator;
    protected final LottoRepository lottoRepository;

    public LottoController() {
        this.lottoGenerator = new LottoGenerator();
        this.lottoRepository = new LottoRepository();
    }

    protected LottoController(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
        this.lottoRepository = new LottoRepository();
    }

    public PurchasedLottoDTO purchase(LottoPurchaseSheetDTO lottoPurchaseSheetDTO) {
        final Lotto lotto = lottoGenerator.generate(lottoPurchaseSheetDTO);

        lottoRepository.save(lotto);

        return PurchasedLottoDTO.of(lotto);
    }

    public LottoResultsDTO confirmTheWin(long lottoId, ConfirmTheWinDTO confirmTheWinDTO) {
        final List<Integer> lastWeekWinningNumbers = confirmTheWinDTO.getLastWeekWinningNumbers();

        final Lotto lotto = lottoRepository.findById(lottoId)
                .orElseThrow(NotFoundEntityException::new);

        lotto.confirmTheWin(lastWeekWinningNumbers);

        return LottoResultsDTO.of(lotto);
    }
}
