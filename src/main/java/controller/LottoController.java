package controller;

import java.util.List;
import java.util.Map;

import domain.Lotto;
import domain.LottoRank;
import domain.LottoStatistics;
import domain.WinningLotto;
import service.LottoService;

public class LottoController {
	private final LottoService lottoService;

	public LottoController(LottoService lottoService) {
		this.lottoService = lottoService;
	}

	public int getPurchaseAmount(int purchaseMoney) {
		return lottoService.getPurchaseAmount(purchaseMoney);
	}

	public List<Lotto> purchase(int purchaseAmount) {
		return lottoService.createLottoList(purchaseAmount);
	}

	public LottoStatistics getStatistics(List<Lotto> lottoList, WinningLotto winningLotto) {
		Map<LottoRank, Integer> rankMap = lottoService.calculateRank(lottoList, winningLotto);
		double profit = lottoService.calculateProfit(lottoList, rankMap);

		return new LottoStatistics(rankMap, profit);
	}
}