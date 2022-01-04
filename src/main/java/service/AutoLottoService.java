package service;

import dto.LottoResultDTO;
import repository.LottoRepository;
import repository.Repository;
import service.lotto.LottoBundle;
import service.lotto.LottoResult;
import service.lotto.LottoStore;

import java.util.List;
import java.util.Map;

public class AutoLottoService implements LottoService {
    private final Repository repository = new LottoRepository();

    @Override
    public Long purchaseLotto(int quantity) {
        LottoStore lottoStore = new LottoStore();
        LottoBundle lottoBundle = lottoStore.purchaseLotto(quantity);
        repository.save(lottoBundle);
        return lottoBundle.getId();
    }

    @Override
    public String getPurchasedLottoBundleString(Long lottoBundleId) {
        return repository.getLottoBundle(lottoBundleId).toString();
    }

    @Override
    public LottoResultDTO getLottoResultDTO(List<Integer> winningNumbers, Long lottoBundleId) {
        LottoBundle lottoBundle = repository.getLottoBundle(lottoBundleId);
        lottoBundle.confirmTheWin(winningNumbers);
        return LottoResultDTO.of(lottoBundle);
    }
}
