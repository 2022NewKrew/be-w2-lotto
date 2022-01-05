package dto.response;

import java.util.Map;

import domain.LottoRank;

public class LottoStatistics {
	private final Map<LottoRank, Integer> lottoRankMap;
	private final double profit;

	public LottoStatistics(Map<LottoRank, Integer> lottoRankMap, double profit) {
		this.lottoRankMap = lottoRankMap;
		this.profit = profit;
	}

	public Map<LottoRank, Integer> getLottoRankMap() {
		return lottoRankMap;
	}

	public double getProfit() {
		return profit;
	}
}
