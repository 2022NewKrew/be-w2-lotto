package dto.response;

import java.util.List;

public class LottoStatistics {
	private final List<String> message;
	private final double profit;

	public LottoStatistics(List<String> message, double profit) {
		this.message = message;
		this.profit = profit;
	}

	public List<String> getMessage() {
		return message;
	}

	public double getProfit() {
		return profit;
	}
}
