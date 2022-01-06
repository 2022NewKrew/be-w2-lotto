package controller;

import dto.request.LottoCheckDTO;
import dto.request.LottoPurchaseDTO;
import dto.response.CheckedLottoDTO;
import dto.response.PurchasedLottoDTO;
import model.Lotto;
import model.LottoGenerator;
import repository.LottoRepository;

public class WebController implements Controller {
    private final LottoRepository lottoRepository = new LottoRepository();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Override
    public PurchasedLottoDTO purchase(LottoPurchaseDTO lottoPurchaseDTO) {
        final Lotto lotto = lottoGenerator.generate(lottoPurchaseDTO);

        lottoRepository.save(lotto);

        return PurchasedLottoDTO.of(lotto);
    }

    @Override
    public CheckedLottoDTO check(LottoCheckDTO lottoCheckDTO) {
        final Lotto lotto = lottoRepository.findById(lottoCheckDTO.getLottoId())
                .orElseThrow(RuntimeException::new);

        lotto.check(lottoCheckDTO);

        return CheckedLottoDTO.of(lotto);
    }
}
