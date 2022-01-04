package service;

import dto.LottoResultDTO;

import java.util.List;

public interface LottoService {
    Long purchaseLotto(int quantity);

    String getPurchasedLottoBundleString(Long lottoBundleId);

    LottoResultDTO getLottoResultDTO(List<Integer> winningNumbers, Long lottoBundleId);
}
