package controller;

import java.util.List;
import java.util.Map;

import domain.Lotto;
import domain.LottoWinningRank;
import service.LottoService;

public class LottoController {
	private final LottoService lottoService;

	public LottoController(LottoService lottoService) {
		this.lottoService = lottoService;
	}

	public void start() throws Exception {
		int purchaseAmount = lottoService.getPurchaseAmount();

		List<Lotto> lottoList = lottoService.createLottoList(purchaseAmount);
		Lotto winningLotto = lottoService.createWinningLotto();

		Map<LottoWinningRank, Integer> rankMap = lottoService.calculateLottoRank(lottoList, winningLotto);
		lottoService.printLottoStatistics(rankMap);

		System.out.println("총 수익률은 "
			+ String.format("%.2f", lottoService.calculatePurchase(purchaseAmount, rankMap))
			+ "%입니다.");
	}
}