package dto.response;

import java.util.List;

import domain.Lotto;

public class LottoPurchaseAmount {
	private final int totalAmount;
	private final int customAmount;
	private final int autoAmount;
	private final List<Lotto> lottoList;

	public LottoPurchaseAmount(int totalAmount, int customAmount, int autoAmount,
		List<Lotto> lottoList) {
		this.totalAmount = totalAmount;
		this.customAmount = customAmount;
		this.autoAmount = autoAmount;
		this.lottoList = lottoList;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public int getCustomAmount() {
		return customAmount;
	}

	public int getAutoAmount() {
		return autoAmount;
	}

	public List<Lotto> getLottoList() {
		return lottoList;
	}
}
