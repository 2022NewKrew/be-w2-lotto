package controller;

import java.util.List;
import java.util.Map;

import domain.Lotto;
import domain.LottoRank;
import domain.LottoValidator;
import domain.WinningLotto;
import dto.request.LottoPurchaseInfo;
import dto.response.LottoPurchaseAmount;
import dto.response.LottoStatistics;
import service.LottoService;

public class LottoController {
	private final LottoService lottoService;

	public LottoController(LottoService lottoService) {
		this.lottoService = lottoService;
	}

	public LottoPurchaseAmount getPurchaseAmount(LottoPurchaseInfo lottoPurchaseInfo) {
		LottoValidator.validateLottoPurchaseInfo(lottoPurchaseInfo);

		return lottoService.getPurchaseAmount(lottoPurchaseInfo);
	}

	public List<Lotto> purchase(int purchaseAmount) {
		LottoValidator.validateLottoPurchaseAmount(purchaseAmount);

		return lottoService.createLottoList(purchaseAmount);
	}

	public LottoStatistics getStatistics(List<Lotto> lottoList, WinningLotto winningLotto) {
		LottoValidator.validateLottoList(lottoList);
		LottoValidator.validateWinningLotto(winningLotto);

		Map<LottoRank, Integer> rankMap = lottoService.calculateRank(lottoList, winningLotto);
		double profit = lottoService.calculateProfit(lottoList, rankMap);

		return new LottoStatistics(rankMap, profit);
	}
}