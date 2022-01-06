package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Lotto;
import domain.LottoGenerator;
import domain.LottoInfo;
import domain.LottoRank;
import domain.WinningLotto;
import dto.request.LottoPurchaseInfo;
import dto.response.LottoPurchaseAmount;

public class LottoService {
	public LottoPurchaseAmount purchase(LottoPurchaseInfo lottoPurchaseInfo) {
		int totalAmount = LottoGenerator.getAmountOfLotto(lottoPurchaseInfo.getPurchaseMoney());
		int customAmount = lottoPurchaseInfo.getCustomLottoList().size();
		int autoAmount = totalAmount - customAmount;

		List<Lotto> lottoList = new ArrayList<>(lottoPurchaseInfo.getCustomLottoList());
		lottoList.addAll(createAutoLottoList(autoAmount));

		return new LottoPurchaseAmount(totalAmount, customAmount, autoAmount, lottoList);
	}

	public List<Lotto> createAutoLottoList(int amount) {
		List<Lotto> lottoList = new ArrayList<>();

		for (int number = 0; number < amount; number++) {
			lottoList.add(LottoGenerator.generateLotto());
		}

		return lottoList;
	}

	public Map<LottoRank, Integer> calculateRank(List<Lotto> lottoList, WinningLotto winningLotto) {
		Map<LottoRank, Integer> rankMap = new HashMap<>();

		for (LottoRank rank : LottoRank.values()) {
			rankMap.put(rank, 0);
		}

		for (Lotto lotto : lottoList) {
			LottoRank lottoRank = winningLotto.calculateRank(lotto);
			rankMap.put(lottoRank, rankMap.get(lottoRank) + 1);
		}

		return rankMap;
	}

	public double calculateProfit(List<Lotto> lottoList, Map<LottoRank, Integer> rankMap) {
		long profit = 0;
		int purchaseMoney = lottoList.size() * LottoInfo.PRICE;

		for (LottoRank rank : LottoRank.getValidLottoRankList()) {
			profit += rank.getReward() * rankMap.get(rank);
		}

		return (double)(profit - purchaseMoney) / purchaseMoney * 100.0;
	}

	public List<String> makeRankToMessage(Map<LottoRank, Integer> rankMap) {
		List<String> message = new ArrayList<>();

		for (LottoRank rank : LottoRank.getValidLottoRankList()) {
			message.add(rank.getMessage() + " (" + rank.getReward() + "원) - " + rankMap.get(rank) + "개");
		}

		return message;
	}
}

