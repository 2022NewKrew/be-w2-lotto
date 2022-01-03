package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import domain.Lotto;
import domain.LottoConfig;
import domain.LottoGenerator;
import domain.LottoWinningRank;
import util.IOUtils;
import util.Message;

public class LottoService {
	public int getPurchaseAmount() throws Exception {
		System.out.println(Message.INPUT_LOTTO_PURCHASE_AMOUNT);
		int purchaseAmount = Integer.parseInt(IOUtils.BR.readLine());

		return purchaseAmount;
	}

	public List<Lotto> createLottoList(int purchaseAmount) {
		int amountOfLotto = getAmountOfLotto(purchaseAmount);

		List<Lotto> lottoList = new ArrayList<>();

		for (int number = 0; number < amountOfLotto; number++) {
			Lotto lotto = LottoGenerator.generateLotto();
			System.out.println(lotto.getLottoNumberList());
			lottoList.add(lotto);
		}
		System.out.println();

		return lottoList;
	}

	public int getAmountOfLotto(int purchaseAmount) {
		int amountOfLotto = LottoConfig.getAmountOfLotto(purchaseAmount);
		System.out.println(amountOfLotto + Message.LOTTO_PURCHASED_NUMBER);

		return amountOfLotto;
	}

	public Lotto createWinningLotto() throws Exception {
		System.out.println(Message.INPUT_LOTTO_WINNING_NUMBER);
		StringTokenizer st = new StringTokenizer(IOUtils.BR.readLine(), ",");

		List<Integer> winningLotto = IOUtils.stringTokenizerToIntegerList(st);
		System.out.println();

		return new Lotto(winningLotto);
	}

	public Map<LottoWinningRank, Integer> calculateLottoRank(List<Lotto> lottoList, Lotto winningLotto) {
		Map<LottoWinningRank, Integer> rankMap = new HashMap<>();

		for (LottoWinningRank rank : LottoWinningRank.values()) {
			rankMap.put(rank, 0);
		}

		for (Lotto lotto : lottoList) {
			LottoWinningRank lottoWinningRank = LottoWinningRank.calculate(lotto, winningLotto);
			rankMap.put(lottoWinningRank, rankMap.get(lottoWinningRank) + 1);
		}

		return rankMap;
	}

	public void printLottoStatistics(Map<LottoWinningRank, Integer> rankMap) {
		StringBuilder sb = new StringBuilder();
		sb.append(Message.LOTTO_WINNING_STATISTICS + "\n");
		sb.append(Message.HORIZONTAL_LINE + "\n");

		List<LottoWinningRank> rankList = LottoWinningRank.getValidLottoWinningRankList();

		for (LottoWinningRank rank : rankList) {
			sb.append(rank.getNumberOfMatches() + "개 일치 (");
			sb.append(rank.getReward() + "원) - ");
			sb.append(rankMap.get(rank) + "개\n");
		}

		System.out.println(sb);
	}

	public double calculatePurchase(int purchaseAmount, Map<LottoWinningRank, Integer> rankMap) {
		int winningAmount = 0;

		for (LottoWinningRank rank : LottoWinningRank.getValidLottoWinningRankList()) {
			winningAmount = rank.getReward() * rankMap.get(rank);
		}

		return (double)winningAmount / (double)purchaseAmount * 100.0;
	}
}

