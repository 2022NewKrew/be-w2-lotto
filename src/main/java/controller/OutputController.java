package controller;

import dto.LottoResultDTO;

import java.util.List;

public interface OutputController {

    String showPurchasedLottoBundle(Long lottoBundleId);

    LottoResultDTO showPurchasedLottoResults(List<Integer> winningNumbers, Long lottoBundleId);
}
