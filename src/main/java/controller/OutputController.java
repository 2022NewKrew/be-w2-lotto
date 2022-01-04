package controller;

import dto.LastWeekWinningNumberDTO;
import dto.LottoResultDTO;

import java.util.List;

public interface OutputController {

    String showPurchasedLottoBundle(Long lottoBundleId);

    LottoResultDTO showPurchasedLottoResults(LastWeekWinningNumberDTO lastWeekWinningNumberDTO, Long lottoBundleId);
}
