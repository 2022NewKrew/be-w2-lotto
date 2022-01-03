package lotto.step1.controller;

import lotto.step1.dto.request.LastWeekWinningNumbersDTO;
import lotto.step1.dto.response.LottoResultsDTO;
import lotto.step1.dto.response.PurchasedLottoDTO;
import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.exception.NotFoundEntityException;
import lotto.step1.model.Lotto;
import lotto.step1.model.LottoGenerator;
import lotto.step1.repository.LottoRepository;

import java.util.List;

public class ConsoleLottoController {
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final LottoRepository lottoRepository = new LottoRepository();

    public PurchasedLottoDTO purchase(LottoPurchaseSheetDTO lottoPurchaseSheetDTO) {
        final Lotto lotto = lottoGenerator.generate(lottoPurchaseSheetDTO);

        lottoRepository.save(lotto);

        return PurchasedLottoDTO.of(lotto);
    }

    public LottoResultsDTO confirmTheWin(long lottoId, LastWeekWinningNumbersDTO lastWeekWinningNumbersDTO) {
        final List<Integer> lastWeekWinningNumbers = lastWeekWinningNumbersDTO.getLastWeekWinningNumbers();

        final Lotto lotto = lottoRepository.findById(lottoId)
                .orElseThrow(NotFoundEntityException::new);

        lotto.confirmTheWin(lastWeekWinningNumbers);

        return LottoResultsDTO.of(lotto);
    }
}
