package dto.request;

public class LottoPurchaseInfo {
	private final int purchaseMoney;
	private final int customAmount;

	public LottoPurchaseInfo(int purchaseMoney, int customAmount) {
		this.purchaseMoney = purchaseMoney;
		this.customAmount = customAmount;
	}

	public int getPurchaseMoney() {
		return purchaseMoney;
	}

	public int getCustomAmount() {
		return customAmount;
	}
}
