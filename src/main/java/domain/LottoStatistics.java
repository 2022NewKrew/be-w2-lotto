package domain;

import java.util.Map;

public class LottoStatistics {
	private Map<LottoRank, Integer> lottoRankMap;
	private double profit;

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
